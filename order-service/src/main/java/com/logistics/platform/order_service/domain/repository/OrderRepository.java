package com.logistics.platform.order_service.domain.repository;

import com.logistics.platform.order_service.domain.model.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
