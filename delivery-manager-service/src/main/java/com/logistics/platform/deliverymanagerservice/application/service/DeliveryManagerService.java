package com.logistics.platform.deliverymanagerservice.application.service;

import com.logistics.platform.deliverymanagerservice.domain.model.DeliveryManager;
import com.logistics.platform.deliverymanagerservice.domain.model.DeliveryType;
import com.logistics.platform.deliverymanagerservice.domain.repository.DeliveryManagerRepository;
import com.logistics.platform.deliverymanagerservice.infrastructure.client.HubClient;
import com.logistics.platform.deliverymanagerservice.presentation.global.exception.CustomApiException;
import com.logistics.platform.deliverymanagerservice.presentation.request.DeliveryManagerRequestDto;
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
  private final HubClient hubClient;

  // 1. 배송담당자 생성
  public DeliveryManagerResponseDto createDeliveryManager(DeliveryManagerRequestDto deliveryManagerRequestDto) {
    // 존재하는 User인지 확인
    // 이미 배송담당자로 등록되어있는 User인지 확인

    // 존재하는 Hub인지 확인 -> 안해도?
    boolean hubExists = hubClient.checkIfHubExists(deliveryManagerRequestDto.getHubId()); // hub에 코드가 있진 x

    if (!hubExists) {
      throw new CustomApiException("존재하지 않는 허브ID입니다.");
    }

    // 가장 큰 배송순번 조회 -> 배송 타입에 따라 다르게 해야? -> 아니면 나중에 조회 할 때 타입에 따라 순번?
    Long maxOrderNumber = deliveryManagerRepository.findMaxDeliveryOrderNumber().orElse(0L)+ 1;

    // 유효한 배송타입인지 확인 -> 성능상 이게 위쪽에서 하는게 좋을듯
    validateDeliveryType(deliveryManagerRequestDto.getDeliveryType());

    DeliveryManager savedDeliveryManager = DeliveryManager.builder()
        .userId(deliveryManagerRequestDto.getUserId())
        .hubId(deliveryManagerRequestDto.getHubId())
        .slackId(deliveryManagerRequestDto.getSlackId())
        .deliveryType(deliveryManagerRequestDto.getDeliveryType())
        .deliveryOrderNumber(maxOrderNumber) // 자동 증가
        .build();

    savedDeliveryManager = deliveryManagerRepository.save(savedDeliveryManager);

    return new DeliveryManagerResponseDto(savedDeliveryManager);
  }
  // 피드백 참고하여 검증로직 아래로 옮김


  // 2. 배송담당자 수정
  @Transactional
  public DeliveryManagerResponseDto updateDeliveryManager(UUID deliveryManagerId, DeliveryManagerRequestDto deliveryManagerRequestDto){

    DeliveryManager deliveryManager = deliveryManagerRepository.findById(deliveryManagerId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송담당자ID입니다."));

    if (deliveryManager.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 배송담당자입니다.");
    }

    deliveryManager.updateDeliveryManager(deliveryManagerRequestDto);
    DeliveryManager savedDeliveryManager = deliveryManagerRepository.save(deliveryManager);

    return new DeliveryManagerResponseDto(savedDeliveryManager);

  }


  // 3. 배송담당자 단건 조회
  @Transactional(readOnly = true)
  public DeliveryManagerResponseDto getDeliveryManager(UUID deliveryManagerId) {

    DeliveryManager deliveryManager = deliveryManagerRepository.findById(deliveryManagerId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송담당자ID 입니다."));

    if(deliveryManager.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 배송담당자입니다.");
    }

    return new DeliveryManagerResponseDto(deliveryManager);
  }


  // 4. 배송담당자 목록 조회
  @Transactional(readOnly = true)
  public PagedModel<DeliveryManagerResponseDto> getDeliveryManagersPage(
      List<UUID> uuidList, Predicate predicate, Pageable pageable) {

    Page<DeliveryManagerResponseDto> deliveryManagerResponseDtoPage
        = deliveryManagerRepository.findAll(uuidList, predicate, pageable);

    return new PagedModel<>(deliveryManagerResponseDtoPage);
  }


  // 5. 배송담당자 삭제
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


  // 배송타입 검증
  public void validateDeliveryType(DeliveryType deliveryType) {
    if (deliveryType == null) {
      throw new CustomApiException("배송 유형이 비어있습니다.");
    }
    if (deliveryType != DeliveryType.HUB && deliveryType != DeliveryType.COMPANY) {
      throw new CustomApiException("유효하지 않은 배송 유형입니다.");
    }
  }

  @Transactional
  public DeliveryManagerResponseDto getNextAvailableDeliveryManager() {
    // 요건 다음 배송순번이 아닌 배송순번 1번째인 사람만 조회되는듯
    DeliveryManager nextManager = deliveryManagerRepository.findFirstByIsDeletedFalseAndDeliveryTypeOrderByDeliveryOrderNumberAsc(DeliveryType.HUB);

    if (nextManager == null) {
      throw new CustomApiException("배정 가능한 배송담당자가 없습니다.");
    }

    // 최소 및 최대 배송 순번 조회 -> 타입에 따라 다르게 되어있지 않음
    Long minOrderNumber = deliveryManagerRepository.findMinDeliveryOrderNumber()
        .orElseThrow(() -> new CustomApiException("배송 순번 조회 오류"));
    Long maxOrderNumber = deliveryManagerRepository.findMaxDeliveryOrderNumber()
        .orElseThrow(() -> new CustomApiException("배송 순번 조회 오류"));

    // 배송 순번 증가 및 순환 로직 -> 배송순번을 변경하는 것 보다 시스템에서 다음 호출할 배송순번을 기억하는 것이 좋을듯
    Long currentOrderNumber = nextManager.getDeliveryOrderNumber();
    Long nextOrderNumber = (currentOrderNumber >= maxOrderNumber) ? minOrderNumber : currentOrderNumber + 1;

    nextManager.setDeliveryOrderNumber(nextOrderNumber);  // 다음 순번 설정
    deliveryManagerRepository.save(nextManager);  // 업데이트된 순번 저장

    return new DeliveryManagerResponseDto(nextManager.getId());
  }

}
