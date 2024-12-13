package com.logistics.platform.delivery_service.deliveryRoute.infrastructure.client;

import com.logistics.platform.delivery_service.deliveryRoute.domain.application.service.dto.DeliveryManagerResponseDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "delivery-manager-service")
public interface DeliveryManagerClient {

  @GetMapping("/api/delivery-managers/{managerId}/info")
  DeliveryManagerResponseDto getNextAvailableDeliveryManager();

}
