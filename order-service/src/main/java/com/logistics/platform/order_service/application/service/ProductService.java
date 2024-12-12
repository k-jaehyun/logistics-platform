package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import java.util.UUID;

public interface ProductService {

  ProductResponseDto getProductDtoByProductId(UUID productId);

  void adjustProductQuantity(UUID productId, Long productQuantity);
}
