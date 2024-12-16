package com.logistics.platform.hub_service.application.service;

import com.logistics.platform.hub_service.application.service.kakao.KakaoMobilityService;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.model.HubRoute;
import com.logistics.platform.hub_service.domain.repository.HubRepository;
import com.logistics.platform.hub_service.domain.repository.HubRouteRepository;
import com.logistics.platform.hub_service.presentation.global.ex.CustomApiException;
import com.logistics.platform.hub_service.presentation.request.HubRouteCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubRouteCreateResponse;
import com.logistics.platform.hub_service.presentation.response.HubRouteResponse;
import java.util.ArrayList;
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
  public List<HubRouteCreateResponse> createHubRoute(HubRouteCreateRequest hubRouteCreateRequest) {
    Hub startHub = hubRepository.findByHubIdAndIsDeletedFalse(hubRouteCreateRequest.getStartHubId())
        .orElseThrow(
            () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));
    Hub endHub = hubRepository.findByHubIdAndIsDeletedFalse(hubRouteCreateRequest.getEndHubId())
        .orElseThrow(
            () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));

    // 경도, 위도로 출발허브 - 중앙허브 - 도착허브 를 거치는 거리, 시간 구하기
    // 1) 출발 허브 id와 출발 허브의 중앙허브 우편번호로 중앙허브 찾아오기
    Hub centralHub = hubRepository.findByPostalCodeAndIsDeletedFalse(startHub.getCenterPostalCode())
        .orElseThrow(
            () -> new CustomApiException("해당 우편번호를 가진 중앙허브가 존재하지 않습니다."));
    // 2) 출발 허브 - 중앙허브, 중앙허브 - 도착허브 거리 계산 후 합산해서 저장
    List<Double> estimatedDuration = new ArrayList<>();
    List<Double> estimatedDistance = new ArrayList<>();
    // 출발 허브 - 중앙 허브 경로 계산
    List<String> firstDirections = kakaoMobilityService.getDirections(
        startHub.getLongitude() + "," + startHub.getLatitude(),
        centralHub.getLongitude() + "," + centralHub.getLatitude());
    estimatedDuration.add(Double.valueOf(firstDirections.get(0)));
    estimatedDistance.add(Double.valueOf(firstDirections.get(1)));
    // 중앙 허브 - 도착 허브 경로 계산
    List<String> secondDirections = kakaoMobilityService.getDirections(
        centralHub.getLongitude() + "," + centralHub.getLatitude(),
        endHub.getLongitude() + "," + endHub.getLatitude());
    estimatedDuration.add(Double.valueOf(secondDirections.get(0)));
    estimatedDistance.add(Double.valueOf(secondDirections.get(1)));

    HubRoute hubRoute = HubRoute.builder()
        .startHubId(startHub.getHubId())
        .endHubId(endHub.getHubId())
        .estimatedDuration(estimatedDuration)
        .estimatedDistance(estimatedDistance)
        .createdBy("임시 생성자")
        .isDeleted(false)
        .build();
    HubRoute savedHubRoute = hubRouteRepository.save(hubRoute);

    List<HubRouteCreateResponse> savedHubRouteList = new ArrayList<>();
    savedHubRouteList.add(new HubRouteCreateResponse(savedHubRoute));

    return savedHubRouteList;
  }

//  @Transactional(readOnly = true)
//  public HubRouteResponse getHubRoute(String classification) {
//    HubRoute hubRoute = hubRouteRepository.findByClassificationAndIsDeletedFalse(classification)
//        .orElseThrow(
//            () -> new CustomApiException("해당 경로의 허브 배송 경로 정보가 존재하지 않습니다."));
//    return new HubRouteResponse(hubRoute);
//  }
}
