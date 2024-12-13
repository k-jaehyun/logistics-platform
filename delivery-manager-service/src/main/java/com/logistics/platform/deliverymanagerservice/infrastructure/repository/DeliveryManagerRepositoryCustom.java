package com.logistics.platform.deliverymanagerservice.infrastructure.repository;

import com.logistics.platform.deliverymanagerservice.domain.model.DeliveryManager;
import com.logistics.platform.deliverymanagerservice.presentation.response.DeliveryManagerResponseDto;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryManagerRepositoryCustom {
  Page<DeliveryManagerResponseDto> findAll(
      List<UUID> uuidList, Predicate predicate, Pageable pageable);

}
