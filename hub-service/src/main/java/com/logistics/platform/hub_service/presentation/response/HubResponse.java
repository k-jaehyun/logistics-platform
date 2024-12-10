package com.logistics.platform.hub_service.presentation.response;

import com.logistics.platform.hub_service.domain.model.Hub;
import java.util.UUID;
import lombok.Getter;

@Getter
public class HubResponse {

  private UUID hubId;

  private String hubName;

  private String address;

  private double latitude;

  private double longitude;

  private boolean isDeleted;

  public HubResponse(Hub hub) {
    this.hubId = hub.getHubId();
    this.hubName = hub.getHubName();
    this.address = hub.getAddress();
    this.latitude = hub.getLatitude();
    this.longitude = hub.getLongitude();
    this.isDeleted = hub.isDeleted();
  }
}
