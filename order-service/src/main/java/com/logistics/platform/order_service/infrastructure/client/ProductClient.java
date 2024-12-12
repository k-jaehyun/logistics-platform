package com.logistics.platform.order_service.infrastructure.client;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import com.logistics.platform.order_service.application.service.ProductService;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductClient extends ProductService {

  @GetMapping("/api/products/{productId}/info")
  ProductResponseDto getProductDtoByProductId(@PathVariable(value = "productId") UUID productId);

  @PostMapping("/api/products/{productId}/quantity/adjustment")
  void adjustProductQuantity(
      @PathVariable(value = "productId") UUID productId,
      @RequestParam(value = "quantity") Long quantity);
}
