package com.logistics.platform.hub_service.application.service;

import com.google.maps.errors.ApiException;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.repository.HubRepository;
import com.logistics.platform.hub_service.presentation.global.ex.CustomApiException;
import com.logistics.platform.hub_service.presentation.request.HubCreateRequest;
import com.logistics.platform.hub_service.presentation.response.AddressResponse;
import com.logistics.platform.hub_service.presentation.response.HubResponse;
import com.logistics.platform.hub_service.presentation.util.GeoUtils;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HubService {

  private final HubRepository hubRepository;
  private final GeocodingService geocodingService;

  public HubResponse createHub(HubCreateRequest hubCreateRequest)
      throws IOException, InterruptedException, ApiException {

    Hub exsitHub = hubRepository.findByHubNameAndIsDeletedFalse(
        hubCreateRequest.getHubName());
    log.info("존재하는 허브 이름 = " + exsitHub.getHubName());
    if (exsitHub.getHubName().equals(hubCreateRequest.getHubName())) {
      throw new CustomApiException("해당 허브 이름이 이미 존재합니다.");
    }

    AddressResponse latLngByAddress = geocodingService.getLatLngByAddress(
        hubCreateRequest.getAddress());

    Hub hub = Hub.builder()
        .hubName(hubCreateRequest.getHubName())
        .address(hubCreateRequest.getAddress())
        .longitude(latLngByAddress.getLongitude())
        .latitude(latLngByAddress.getLatitude())
        .location(GeoUtils.toPoint(latLngByAddress.getLongitude(), latLngByAddress.getLatitude()))
        .isDeleted(false)
        .build();

    Hub savedHub = hubRepository.save(hub);
    return new HubResponse(savedHub);
  }
}
