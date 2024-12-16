package com.logistics.platform.order_service.application.service.delivery;

import java.util.UUID;

public interface DeliveryService {

  void createDelivery(UUID userId, UUID startHubId, UUID endHubId, UUID orderId, String recipient,
      String userSlackId, String address);

}
