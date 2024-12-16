package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.domain.model.Order;
import com.logistics.platform.order_service.infrastructure.client.DeliveryClient;
import com.logistics.platform.order_service.infrastructure.request.DeliveryRequestDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

  private final DeliveryClient deliveryClient;

  @Override
  @Async
  public void createDelivery(Order order, UUID userId, String userSlackId) {
    deliveryClient.createDelivery(new DeliveryRequestDto(order, userId, userSlackId));
  }
}
