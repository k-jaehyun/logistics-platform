package com.logistics.platform.order_service.presentation.response;

import com.logistics.platform.order_service.domain.model.Order;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

  private UUID orderID;

  private UUID productId;

  private Long productQuantity;

  private UUID supplyCompanyId;

  private UUID receiveCompanyId;

  private String orderRequest;

  public OrderResponseDto(Order order) {
    this.orderID = order.getId();
    this.productId = order.getProductId();
    this.productQuantity = order.getProductQuantity();
    this.supplyCompanyId = order.getSupplyCompayId();
    this.receiveCompanyId = order.getReceiveCompanyId();
    this.orderRequest = order.getOrderRequest();
  }
}
