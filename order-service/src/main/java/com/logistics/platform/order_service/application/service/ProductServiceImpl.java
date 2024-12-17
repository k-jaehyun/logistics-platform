package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import com.logistics.platform.order_service.infrastructure.client.ProductClient;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductClient productClient;

  @Override
  @Cacheable(value = "getProductCache", key = "#productId")
  public ProductResponseDto getProductDtoByProductId(UUID productId) {
    return productClient.getProductDtoByProductId(productId);
  }

  @Override
  public void adjustProductQuantity(UUID productId, Long productQuantity) {
  }
}
