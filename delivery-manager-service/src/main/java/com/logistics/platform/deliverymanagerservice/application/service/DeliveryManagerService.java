package com.logistics.platform.deliverymanagerservice.application.service;

import com.logistics.platform.deliverymanagerservice.domain.model.DeliveryManager;
import com.logistics.platform.deliverymanagerservice.domain.repository.DeliveryManagerRepository;
import com.logistics.platform.deliverymanagerservice.presentation.global.exception.CustomApiException;
import com.logistics.platform.deliverymanagerservice.presentation.request.DeliveryManagerRequestDto;
import com.logistics.platform.deliverymanagerservice.presentation.request.DeliveryManagerUpdateRequestDto;
import com.logistics.platform.deliverymanagerservice.presentation.response.DeliveryManagerResponseDto;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeliveryManagerService {

  private final DeliveryManagerRepository deliveryManagerRepository;

  public DeliveryManagerResponseDto createDeliveryManager(DeliveryManagerRequestDto deliveryManagerRequestDto) {
    // 존재하는 User인지 확인
    // 이미 배송담당자로 등록되어있는 User인지 확인
    // 존재하는 Hub인지 확인
    DeliveryManager savedDeliveryManager = DeliveryManager.builder()
        .userId(deliveryManagerRequestDto.getUserId())
        .hubId(deliveryManagerRequestDto.getHubId())
        .slackId(deliveryManagerRequestDto.getSlackId())
        .deliveryType(deliveryManagerRequestDto.getDeliveryType())
        .deliveryOrderNumber(deliveryManagerRequestDto.getDeliveryOrderNumber())
        .build();

    savedDeliveryManager = deliveryManagerRepository.save(savedDeliveryManager);

    return new DeliveryManagerResponseDto(savedDeliveryManager);
  }

  public DeliveryManagerResponseDto updateDeliveryManager(UUID deliveryManagerId, DeliveryManagerUpdateRequestDto deliveryManagerUpdateRequestDto){

    DeliveryManager deliveryManager = deliveryManagerRepository.findById(deliveryManagerId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송담당자ID입니다."));

    if (deliveryManager.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 배송담당자입니다.");
    }

    deliveryManager.updateDeliveryManager(deliveryManagerUpdateRequestDto);
    DeliveryManager savedDeliveryManager = deliveryManagerRepository.save(deliveryManager);

    return new DeliveryManagerResponseDto(savedDeliveryManager);

  }

  @Transactional(readOnly = true)
  public DeliveryManagerResponseDto getDeliveryManager(UUID deliveryManagerId) {

    DeliveryManager deliveryManager = deliveryManagerRepository.findById(deliveryManagerId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송담당자ID 입니다."));

    if(deliveryManager.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 배송담당자입니다.");
    }

    return new DeliveryManagerResponseDto(deliveryManager);
  }

  @Transactional(readOnly = true)
  public PagedModel<DeliveryManagerResponseDto> getDeliveryManagersPage(
      List<UUID> uuidList, Predicate predicate, Pageable pageable) {

    Page<DeliveryManagerResponseDto> deliveryManagerResponseDtoPage
        = deliveryManagerRepository.findAll(uuidList, predicate, pageable);

    return new PagedModel<>(deliveryManagerResponseDtoPage);
  }

  @Transactional
  public DeliveryManagerResponseDto deleteDeliveryManager(UUID deliveryManagerId, String deletedBy) {

    DeliveryManager deliveryManager = deliveryManagerRepository.findById(deliveryManagerId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송담당자ID입니다."));

    if(deliveryManager.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 배송담당자입니다.");
    }

    deliveryManager.deleteDeliveryManager(deletedBy);  // 삭제자 나중에 헤더에서

    return new DeliveryManagerResponseDto(deliveryManager);
  }

}
