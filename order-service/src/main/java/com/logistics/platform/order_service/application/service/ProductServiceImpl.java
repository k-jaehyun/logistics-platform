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
  // TODO product 정보를 가져온 것은 수정하기 위함이라서 캐시가 필요 없을듯
  public ProductResponseDto getProductDtoByProductId(UUID productId, String userName, String userRole) {
    return productClient.getProductDtoByProductId(productId, userName, userRole);
  }

  @Override
  public void adjustProductQuantity(UUID productId, Long productQuantity) {
    productClient.adjustProductQuantity(productId, productQuantity);
  }
}
