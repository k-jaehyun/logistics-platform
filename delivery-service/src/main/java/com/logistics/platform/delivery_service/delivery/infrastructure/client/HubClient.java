package com.logistics.platform.delivery_service.delivery.infrastructure.client;


import com.logistics.platform.delivery_service.deliveryRoute.application.service.dto.DeliveryManagerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hub-service")
public interface HubClient {

  @GetMapping("/api/hubs/{hubId}/info")
  DeliveryManagerResponseDto getHubIdInfo();

}
