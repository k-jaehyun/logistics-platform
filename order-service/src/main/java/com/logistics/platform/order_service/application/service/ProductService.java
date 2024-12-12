package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import java.util.UUID;
import org.springframework.cache.annotation.Cacheable;

public interface ProductService {

  @Cacheable(value = "getProductCache", key = "#productId")
  ProductResponseDto getProductDtoByProductId(UUID uuid);

  void adjustProductQuantity(UUID productId, Long productQuantity);
}
