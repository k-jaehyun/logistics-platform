package com.logistics.platform.delivery_service.delivery.infrastructure.client;


import com.logistics.platform.delivery_service.delivery.application.dto.HubRouteResponseDto;
import com.logistics.platform.delivery_service.deliveryRoute.application.service.dto.DeliveryManagerResponseDto;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hub-service")
public interface HubClient {

  @GetMapping("/api/hub-routes")
  List<HubRouteResponseDto> getHubRoutes(
      @RequestParam("startHubId") UUID startHubId,
      @RequestParam("endHubId") UUID endHubId);
}


