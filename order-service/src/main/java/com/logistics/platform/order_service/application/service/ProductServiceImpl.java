package com.logistics.platform.order_service.application.service;

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
  @Cacheable(value = "productValidationCache", key = "#productId")
  public Boolean validateProductId(UUID productId) {
    return productClient.validateProductId(productId);
  }

  @Override
  @Cacheable(value = "productPriceCache", key = "#productId")
  public Long getPriceByProductId(UUID productId) {
    return productClient.getPriceByProductId(productId);
  }
}
