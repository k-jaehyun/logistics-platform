package com.logistics.platform.delivery_service.deliveryRoute.presentation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.logistics.platform.delivery_service.deliveryRoute.domain.model.DeliveryRouteStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryRouteRequestDto {

  private UUID deliveryId;
  private UUID startHubId;
  private UUID endHubId;
  private UUID deliveryManagerId;
  private Long estimatedDuration;
  private Long estimatedDistance;
  private DeliveryRouteStatus status;
  private Long sequence;

}
