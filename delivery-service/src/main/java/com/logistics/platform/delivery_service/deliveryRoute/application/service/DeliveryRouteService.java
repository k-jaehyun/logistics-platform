package com.logistics.platform.delivery_service.deliveryRoute.application.service;


import com.logistics.platform.delivery_service.deliveryRoute.application.service.dto.DeliveryManagerResponseDto;
import com.logistics.platform.delivery_service.deliveryRoute.domain.model.DeliveryRoute;
import com.logistics.platform.delivery_service.deliveryRoute.domain.model.DeliveryRouteStatus;
import com.logistics.platform.delivery_service.deliveryRoute.domain.repository.DeliveryRouteRepository;
import com.logistics.platform.delivery_service.deliveryRoute.infrastructure.client.DeliveryManagerClient;
import com.logistics.platform.delivery_service.deliveryRoute.presentation.global.exception.CustomApiException;
import com.logistics.platform.delivery_service.deliveryRoute.presentation.request.DeliveryRouteRequestDto;
import com.logistics.platform.delivery_service.deliveryRoute.presentation.response.DeliveryRouteResponseDto;
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
public class DeliveryRouteService {

  private final DeliveryRouteRepository deliveryRouteRepository;
  private final DeliveryManagerClient deliveryManagerClient;

  // 1. 배송 경로 생성
  public DeliveryRouteResponseDto createDeliveryRoute(
      DeliveryRouteRequestDto deliveryRouteRequestDto) {

    DeliveryManagerResponseDto deliveryManager =
        deliveryManagerClient.getNextAvailableDeliveryManager();

    if (deliveryManager == null || deliveryManager.getDeliveryManagerId() == null) {
      throw new CustomApiException("배정 가능한 배송담당자가 없습니다.");
    }

    DeliveryRoute deliveryRoute = DeliveryRoute.builder()
        .startHubId(deliveryRouteRequestDto.getStartHubId())
        .endHubId(deliveryRouteRequestDto.getEndHubId())
        .deliveryManagerId(deliveryManager.getDeliveryManagerId())
        .estimatedDuration(deliveryRouteRequestDto.getEstimatedDuration())
        .estimatedDistance(deliveryRouteRequestDto.getEstimatedDistance())
        .status(deliveryRouteRequestDto.getStatus())
        .sequence(deliveryRouteRequestDto.getSequence())
        .build();

    deliveryRoute = deliveryRouteRepository.save(deliveryRoute);

    // 나중에 담당자 배정 로직(배송묶음으로 구현) 호출해서 담당자 지정하는거 생각
    return new DeliveryRouteResponseDto(deliveryRoute);
  }

  // 2. 배송 경로 단건 조회
  @Transactional(readOnly = true)
  public DeliveryRouteResponseDto getDeliveryRoute(UUID deliveryRouteId) {
    DeliveryRoute deliveryRoute = deliveryRouteRepository.findById(deliveryRouteId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송 경로 ID입니다."));

    if (deliveryRoute.getStatus() == DeliveryRouteStatus.DELETED) {
      throw new CustomApiException("이미 삭제된 배송 경로입니다.");
    }

    return new DeliveryRouteResponseDto(deliveryRoute);
  }

  // 3. 배송 경로 목록 조회
  @Transactional(readOnly = true)
  public PagedModel<DeliveryRouteResponseDto> getDeliveryRoutes(List<UUID> uuidList, Predicate predicate, Pageable pageable) {
    Page<DeliveryRouteResponseDto> deliveryRoutePage = deliveryRouteRepository.findAll(uuidList, predicate, pageable);
    return new PagedModel<>(deliveryRoutePage);
  }

  // 4. 배송 경로 수정
  @Transactional
  public DeliveryRouteResponseDto updateDeliveryRoute(UUID deliveryRouteId, DeliveryRouteRequestDto deliveryRouteRequestDto) {
    DeliveryRoute deliveryRoute = deliveryRouteRepository.findById(deliveryRouteId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송 경로 ID입니다."));

    if (deliveryRoute.getStatus() == DeliveryRouteStatus.DELETED) {
      throw new CustomApiException("이미 삭제된 배송 경로입니다.");
    }

    deliveryRoute.updateActualMetrics(deliveryRouteRequestDto.getEstimatedDuration(), deliveryRouteRequestDto.getEstimatedDistance());
    deliveryRoute.updateStatus(deliveryRouteRequestDto.getStatus());
    deliveryRouteRepository.save(deliveryRoute);
    return new DeliveryRouteResponseDto(deliveryRoute);
  }

  // 5. 배송 경로 삭제
  @Transactional
  public DeliveryRouteResponseDto deleteDeliveryRoute(UUID deliveryRouteId, String deletedBy) {
    DeliveryRoute deliveryRoute = deliveryRouteRepository.findById(deliveryRouteId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 배송 경로 ID입니다."));

    if (deliveryRoute.getStatus() == DeliveryRouteStatus.DELETED) {
      throw new CustomApiException("이미 삭제된 배송 경로입니다.");
    }

    deliveryRoute.deleteDeliveryRoute(deletedBy);
    return new DeliveryRouteResponseDto(deliveryRoute);
  }

}

