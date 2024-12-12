package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.domain.model.Order;
import com.logistics.platform.order_service.domain.repository.OrderRepository;
import com.logistics.platform.order_service.presentation.global.exception.CustomApiException;
import com.logistics.platform.order_service.presentation.request.OrderRequestDto;
import com.logistics.platform.order_service.presentation.response.OrderResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductServiceImpl productService;

  // TODO CircuitBreaker 위치 고민해보기
  @CircuitBreaker(name = "OrderService", fallbackMethod = "handlecreateOrderFailue")
  public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

    // productId 검증
    if (!productService.validateProductId(orderRequestDto.getProductId())) {
      throw new CustomApiException("This Product ID does not exist.");
    }

    // product price 반환
    Long totalPrice =
        productService.getPriceByProductId(orderRequestDto.getProductId())
            * orderRequestDto.getProductQuantity();

    // supplyCompanyId 검증

    // receiveCompanyId 검증

    Order order = Order.builder()
        .productId(orderRequestDto.getProductId())
        .supplyCompayId(orderRequestDto.getSupplyCompanyId())
        .receiveCompanyId(orderRequestDto.getReceiveCompanyId())
        .productQuantity(orderRequestDto.getProductQuantity())
        .totalPrice(totalPrice)
        .orderRequest(orderRequestDto.getOrderRequest())
        .createdBy("createdBy") // TODO 생성자 추가
        .build();

    // TODO 배송 생성 추가

    orderRepository.save(order);

    return new OrderResponseDto(order);
  }

  public OrderResponseDto handlecreateOrderFailue(OrderRequestDto orderRequestDto, Throwable t) {
    return new OrderResponseDto(t.getMessage());
  }
}
