package com.logistics.platform.order_service.application.service;

import java.util.UUID;

public interface ProductService {

  Boolean validateProductId(UUID productId);

  Long getPriceByProductId(UUID productId);
}
