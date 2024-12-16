package com.logistics.platform.hub_service.presentation.response;

import com.logistics.platform.hub_service.domain.model.HubRoute;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class HubRouteCreateResponse {

  private UUID hubRouteId;

  private List<Double> estimatedDuration;

  private List<Double> estimatedDistance;

  public HubRouteCreateResponse(HubRoute hubRoute) {
    this.hubRouteId = hubRoute.getHubRouteId();
    this.estimatedDuration = hubRoute.getEstimatedDuration();
    this.estimatedDistance = hubRoute.getEstimatedDistance();
  }
}
