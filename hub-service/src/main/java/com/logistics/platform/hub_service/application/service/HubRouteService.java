package com.logistics.platform.hub_service.application.service;

import com.logistics.platform.hub_service.application.service.kakao.KakaoMobilityService;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.model.HubRoute;
import com.logistics.platform.hub_service.domain.repository.HubRepository;
import com.logistics.platform.hub_service.domain.repository.HubRouteRepository;
import com.logistics.platform.hub_service.presentation.global.ex.CustomApiException;
import com.logistics.platform.hub_service.presentation.request.HubRouteCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubRouteResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HubRouteService {

  private final HubRouteRepository hubRouteRepository;
  private final KakaoMobilityService kakaoMobilityService;
  private final HubRepository hubRepository;

  @Transactional
  public HubRouteResponse createHubRoute(HubRouteCreateRequest hubRouteCreateRequest) {
    Hub startHub = hubRepository.findByHubIdAndIsDeletedFalse(hubRouteCreateRequest.getStartHubId())
        .orElseThrow(
            () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));
    Hub endHub = hubRepository.findByHubIdAndIsDeletedFalse(hubRouteCreateRequest.getEndHubId())
        .orElseThrow(
            () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));
    log.info("startHub = " + startHub.getLatitude() + "," + startHub.getLongitude());
    log.info("endHub = " + endHub.getLatitude() + "," + endHub.getLongitude());

    // 경도, 위도로 거리, 시간 구하기
    List<String> directions = kakaoMobilityService.getDirections(
        startHub.getLongitude() + "," + startHub.getLatitude(),
        endHub.getLongitude() + "," + endHub.getLatitude());
    String duration = directions.get(0);
    String distance = directions.get(1);

    // 우편번호로 구분값 생성해서 저장
    String startHubPostalCode = startHub.getPostalCode();
    String endHubPostalCode = endHub.getPostalCode();
    String classification = startHubPostalCode + "to" + endHubPostalCode;

    if (hubRouteRepository.findByClassificationAndIsDeletedFalse(classification).isPresent()) {
      throw new CustomApiException(
          "이미 해당 경로의 허브 배송 경로 정보가 존재합니다. classification = " + classification);
    }

    HubRoute hubRoute = HubRoute.builder()
        .startHubId(startHub.getHubId())
        .endHubId(endHub.getHubId())
        .estimatedDuration(Double.parseDouble(duration))
        .estimatedDistance(Double.parseDouble(distance))
        .classification(classification)
        .createdBy("임시 생성자")
        .isDeleted(false)
        .build();
    HubRoute savedHubRoute = hubRouteRepository.save(hubRoute);
    return new HubRouteResponse(savedHubRoute);
  }

  @Transactional(readOnly = true)
  public HubRouteResponse getHubRoute(String classification) {
    HubRoute hubRoute = hubRouteRepository.findByClassificationAndIsDeletedFalse(classification)
        .orElseThrow(
            () -> new CustomApiException("해당 경로의 허브 배송 경로 정보가 존재하지 않습니다."));
    return new HubRouteResponse(hubRoute);
  }
}
