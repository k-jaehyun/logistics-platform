package com.logistics.platform.order_service.infrastructure.client;

import com.logistics.platform.order_service.infrastructure.request.DeliveryRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery-service", path = "/api/deliveries")
public interface DeliveryClient {

  @PostMapping
  void createDelivery(@RequestBody DeliveryRequestDto deliveryRequestDto);

}
