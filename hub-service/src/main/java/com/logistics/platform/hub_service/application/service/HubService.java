package com.logistics.platform.hub_service.application.service;

import com.google.maps.errors.ApiException;
import com.logistics.platform.hub_service.domain.model.Hub;
import com.logistics.platform.hub_service.domain.repository.HubRepository;
import com.logistics.platform.hub_service.presentation.request.HubCreateRequest;
import com.logistics.platform.hub_service.presentation.response.AddressResponse;
import com.logistics.platform.hub_service.presentation.response.HubResponse;
import com.logistics.platform.hub_service.presentation.util.GeoUtils;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HubService {

  private final HubRepository hubRepository;
  private final GeocodingService geocodingService;

  public HubResponse createHub(HubCreateRequest hubCreateRequest)
      throws IOException, InterruptedException, ApiException {
    // todo 허브 이름 중복 확인 로직 추가
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
