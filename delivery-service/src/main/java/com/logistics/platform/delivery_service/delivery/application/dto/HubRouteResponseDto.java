package com.logistics.platform.delivery_service.delivery.application.dto;


import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HubRouteResponseDto {

  private UUID startHubId;
  private UUID endHubId;
  private Long estimatedDuration;
  private Long estimatedDistance;

}
