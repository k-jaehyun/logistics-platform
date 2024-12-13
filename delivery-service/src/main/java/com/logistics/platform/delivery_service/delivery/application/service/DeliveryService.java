package com.logistics.platform.delivery_service.delivery.application.service;


import com.logistics.platform.delivery_service.delivery.domain.model.Delivery;
import com.logistics.platform.delivery_service.delivery.domain.model.DeliveryStatus;
import com.logistics.platform.delivery_service.delivery.domain.repository.DeliveryRepository;
import com.logistics.platform.delivery_service.delivery.presentation.global.exception.CustomApiException;
import com.logistics.platform.delivery_service.delivery.presentation.request.DeliveryRequestDto;
import com.logistics.platform.delivery_service.delivery.presentation.response.DeliveryResponseDto;
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
public class DeliveryService {

  private final DeliveryRepository deliveryRepository;

  // 1. 배송 생성
  public DeliveryResponseDto createDelivery(DeliveryRequestDto deliveryRequestDto) {

    Delivery savedDelivery = Delivery.builder()
        .startHubId(deliveryRequestDto.getStartHubId())
        .endHubId(deliveryRequestDto.getEndHubId())
        .orderId(deliveryRequestDto.getOrderId())
        .deliveryStatus(DeliveryStatus.WAITING_AT_HUB)
        .recipient(deliveryRequestDto.getRecipient())
        .recipientSlackId(deliveryRequestDto.getRecipientSlackId())
        .address(deliveryRequestDto.getAddress())
        .build();

    savedDelivery = deliveryRepository.save(savedDelivery);
    return new DeliveryResponseDto(savedDelivery);
  }

  // 2. 배송 단건 조회
  @Transactional(readOnly = true)
  public DeliveryResponseDto getDelivery(UUID deliveryId) {
    Delivery delivery = deliveryRepository.findById(deliveryId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송ID입니다."));

    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_DELETED) {
      throw new CustomApiException("이미 삭제된 배송입니다.");
    }
    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_CANCELLED) {
      throw new CustomApiException("이미 취소된 배송입니다.");
    }
    return new DeliveryResponseDto(delivery);
  }

  // 3. 배송 목록 조회
  @Transactional(readOnly = true)
  public PagedModel<DeliveryResponseDto> getDeliveries(List<UUID> uuidList, Predicate predicate,Pageable pageable) {

    Page<DeliveryResponseDto> deliveryManagerResponseDtoPage
        = deliveryRepository.findAll(uuidList, predicate, pageable);

    return new PagedModel<>(deliveryManagerResponseDtoPage);
  }


  // 4. 배송 수정
  @Transactional
  public DeliveryResponseDto updateDelivery(UUID deliveryId, DeliveryRequestDto deliveryRequestDto) {
    Delivery delivery = deliveryRepository.findById(deliveryId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송ID입니다."));

    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_DELETED) {
      throw new CustomApiException("이미 삭제된 배송입니다.");
    }
    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_CANCELLED) {
      throw new CustomApiException("이미 취소된 배송입니다.");
    }

    delivery.updateDelivery(deliveryRequestDto);
    deliveryRepository.save(delivery);
    return new DeliveryResponseDto(delivery);
  }

  // 5. 배송 삭제
  @Transactional
  public DeliveryResponseDto deleteDelivery(UUID deliveryId, String deletedBy) {
    Delivery delivery = deliveryRepository.findById(deliveryId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송 ID입니다."));

    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_DELETED) {
      throw new CustomApiException("이미 삭제된 배송입니다.");
    }

    delivery.deleteDelivery(deletedBy);
    return new DeliveryResponseDto(delivery);
  }

  // 배송 취소
  @Transactional
  public DeliveryResponseDto cancelDelivery(UUID deliveryId, String cancelledBy) {
    Delivery delivery = deliveryRepository.findById(deliveryId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송 ID입니다."));

    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_DELETED) {
      throw new CustomApiException("이미 삭제된 배송입니다.");
    }
    if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERY_CANCELLED) {
      throw new CustomApiException("이미 취소된 배송입니다.");
    }

    delivery.cancelDelivery(cancelledBy);
    return new DeliveryResponseDto(delivery);
  }

}
