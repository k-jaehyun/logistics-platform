package com.logistics.platform.hub_service.application.service;

import com.logistics.platform.hub_service.application.service.kakao.KakaoMobilityService;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.model.HubRoute;
import com.logistics.platform.hub_service.domain.repository.HubRouteRepository;
import com.logistics.platform.hub_service.presentation.global.ex.CustomApiException;
import com.logistics.platform.hub_service.presentation.request.HubRouteCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubRouteResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HubRouteService {
  private final HubRouteRepository hubRouteRepository;
  private final KakaoMobilityService kakaoMobilityService;

  public HubRouteResponse createHubRoute(HubRouteCreateRequest hubRouteCreateRequest) {
    // 특정 허브 아이디로 startHub, endHub 위도 경도 가져오기
//    Hub hub = hubRepository.findByHubIdAndIsDeletedFalse(hubId).orElseThrow(
//        () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));

    // 임시 (서울 특별시 센터 -> 경기 남부 센터)
    String startHub = "127.1216133,37.4737363";
    String endHub = "127.3881049,37.2015413";

    // 위도 경도로 거리, 시간 구하기
    String duration = kakaoMobilityService.getDirections(startHub, endHub).get(0);
    String distance = kakaoMobilityService.getDirections(startHub, endHub).get(1);

    // 우편번호로 구분값 생성해서 저장하기
    String startHubPostalCode = "05842";
    String endHubPostalCode = "17396";
    String classification = startHubPostalCode+"to"+endHubPostalCode;

    // 해당 우편번호값이 db에 있으면 생성 불가

    HubRoute hubRoute = HubRoute.builder()
        .startHubId(UUID.fromString("063ce504-a2f5-493f-b3b2-b4792ead7234"))
        .endHubId(UUID.fromString("d2fb3667-b38e-46ab-b20f-ec10eb8e36ad"))
        .estimatedDuration(Double.parseDouble(duration))
        .estimatedDistance(Double.parseDouble(distance))
        .classification(classification)
        .createdBy("임시 생성자")
        .isDeleted(false)
        .build();
    HubRoute savedHubRoute = hubRouteRepository.save(hubRoute);
    return new HubRouteResponse(savedHubRoute);
  }
}
