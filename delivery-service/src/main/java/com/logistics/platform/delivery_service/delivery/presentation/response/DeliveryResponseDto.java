package com.logistics.platform.delivery_service.delivery.presentation.response;


import com.logistics.platform.delivery_service.delivery.domain.model.Delivery;
import com.logistics.platform.delivery_service.delivery.domain.model.DeliveryStatus;
import com.querydsl.core.annotations.QueryProjection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDto {

  private UUID deliveryId;
  private Long userId;
  private UUID deliveryRouteId;
  private UUID startHubId;
  private UUID endHubId;
  private UUID orderId;
  private DeliveryStatus deliveryStatus;
  private String recipient;
  private String recipientSlackId;
  private String address;

  @QueryProjection
  public DeliveryResponseDto(Delivery delivery) {
    this.deliveryId = delivery.getId();
    this.userId = delivery.getUserId();
    this.deliveryRouteId = delivery.getDeliveryRouteId();
    this.startHubId = delivery.getStartHubId();
    this.endHubId = delivery.getEndHubId();
    this.orderId = delivery.getOrderId();
    this.deliveryStatus = delivery.getDeliveryStatus();
    this.recipient = delivery.getRecipient();
    this.recipientSlackId = delivery.getRecipientSlackId();
    this.address = delivery.getAddress();
  }
}
