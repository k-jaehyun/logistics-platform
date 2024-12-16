package com.logistics.platform.order_service.infrastructure.request;

import com.logistics.platform.order_service.domain.model.Order;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequestDto {

  private UUID orderId;

  private String address; // Order에 address 추가해줘야할듯

  private UUID recipientId; // recipientId인지 recipient인지

  private String recipientSlackId;

  public DeliveryRequestDto(Order order, UUID userId, String userSlackId) {
    this.orderId = order.getId();
    this.address = order.getAddress();
    this.recipientId = userId;
    this.recipientSlackId = userSlackId;
  }
}
