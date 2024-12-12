package com.logistics.platform.order_service.infrastructure.client;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import com.logistics.platform.order_service.application.service.ProductService;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient extends ProductService {

  @GetMapping("/api/products/{productId}/info")
  ProductResponseDto getProductDtoByProductId(@PathVariable(value = "productId") UUID productId);
}
