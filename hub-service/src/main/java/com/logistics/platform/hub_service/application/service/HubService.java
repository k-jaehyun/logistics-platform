package com.logistics.platform.hub_service.application.service;

import com.google.maps.errors.ApiException;
import com.logistics.platform.hub_service.application.service.google.GeocodingService;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.model.HubType;
import com.logistics.platform.hub_service.domain.repository.HubRepository;
import com.logistics.platform.hub_service.presentation.global.ex.CustomApiException;
import com.logistics.platform.hub_service.presentation.request.HubCreateRequest;
import com.logistics.platform.hub_service.presentation.request.HubModifyRequest;
import com.logistics.platform.hub_service.presentation.response.AddressResponse;
import com.logistics.platform.hub_service.presentation.response.HubResponse;
import com.logistics.platform.hub_service.presentation.util.GeoUtils;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HubService {

  private final HubRepository hubRepository;
  private final GeocodingService geocodingService;

  public HubResponse createHub(HubCreateRequest hubCreateRequest)
      throws IOException, InterruptedException, ApiException {

    if (hubRepository.findByHubNameAndIsDeletedFalse(
        hubCreateRequest.getHubName()).isPresent()) {
      throw new CustomApiException("해당 허브 이름이 이미 존재합니다.");
    }

    HubType hubTypeSet =
        !hubCreateRequest.getIsHubTypeReceiver() ? HubType.localHub
            : HubType.centralHub;

    AddressResponse latLngByAddress = geocodingService.getLatLngByAddress(
        hubCreateRequest.getPostalCode());

    Hub hub = Hub.builder()
        .hubManagerId(hubCreateRequest.getHubManagerId())
        .hubName(hubCreateRequest.getHubName())
        .hubType(hubTypeSet)
        .roadAddress(hubCreateRequest.getRoadAddress())
        .postalCode(hubCreateRequest.getPostalCode())
        .longitude(latLngByAddress.getLongitude())
        .latitude(latLngByAddress.getLatitude())
        .location(GeoUtils.toPoint(latLngByAddress.getLongitude(), latLngByAddress.getLatitude()))
        .createdBy("임시 생성자")
        .isDeleted(false)
        .build();

    Hub savedHub = hubRepository.save(hub);
    return new HubResponse(savedHub);
  }

  @Transactional(readOnly = true)
  @Cacheable(cacheNames = "hubCache", cacheManager = "cacheManager")
  public HubResponse getHub(UUID hubId) {
    log.info("캐시 작동 확인");
    Hub hub = hubRepository.findByHubIdAndIsDeletedFalse(hubId).orElseThrow(
        () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));
    return new HubResponse(hub);
  }

  @Transactional(readOnly = true)
  public Page<HubResponse> searchHubs(String keyword, Pageable pageable) {
    Page<Hub> hubs;
    if (keyword == null || keyword.trim().isEmpty()) {
      hubs = hubRepository.findAllByIsDeletedFalse(pageable);
    } else {
      hubs = hubRepository.findAllByHubNameContainsIgnoreCaseAndIsDeletedFalse(keyword, pageable);
    }
    return hubs.map(HubResponse::new);
  }

  @Transactional
  public HubResponse modifyHub(UUID hubId, HubModifyRequest hubModifyRequest) {

    if (hubRepository.findByHubNameAndIsDeletedFalse(
        hubModifyRequest.getHubName()).isPresent()) {
      throw new CustomApiException("해당 허브 이름이 이미 존재합니다.");
    }

    Hub hub = hubRepository.findByHubIdAndIsDeletedFalse(hubId).orElseThrow(
        () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));

    hub.changeHub(hubModifyRequest);
    Hub savedHub = hubRepository.save(hub);
    return new HubResponse(savedHub);
  }

  @Transactional
  public void deleteHub(UUID hubId) {
    Hub hub = hubRepository.findByHubIdAndIsDeletedFalse(hubId).orElseThrow(
        () -> new CustomApiException("해당 hubId가 존재하지 않습니다."));
    hub.deleteHub();
  }
}
