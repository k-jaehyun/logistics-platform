package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.domain.model.Order;
import java.util.UUID;

public interface DeliveryService {

  void createDelivery(Order order, UUID userId, String userSlackId);

}
