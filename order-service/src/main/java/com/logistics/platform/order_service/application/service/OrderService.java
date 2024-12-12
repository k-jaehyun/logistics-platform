package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.application.dto.ProductResponseDto;
import com.logistics.platform.order_service.domain.model.Order;
import com.logistics.platform.order_service.domain.repository.OrderRepository;
import com.logistics.platform.order_service.presentation.global.exception.CustomApiException;
import com.logistics.platform.order_service.presentation.request.OrderRequestDto;
import com.logistics.platform.order_service.presentation.response.OrderResponseDto;
import com.querydsl.core.types.Predicate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductServiceImpl productService;

  // TODO CircuitBreaker 위치 고민해보기
  @CircuitBreaker(name = "OrderService", fallbackMethod = "handleOrderFailue")
  public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

    // ProductDto 형태로 응답을 받아 요청을 최소화
    ProductResponseDto product = productService.getProductDtoByProductId(
        orderRequestDto.getProductId());

    Long totalPrice = product.getPrice() * orderRequestDto.getProductQuantity();

    // 재고 확인
    if (product.getCount() < orderRequestDto.getProductQuantity()) {
      throw new CustomApiException("재고보다 주문 수량이 많습니다.");
    }

    // TODO 주문 수량만큼 재고 차감

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

  public OrderResponseDto getOrder(UUID orderId) {

    // TODO 본인 주문만 조회되도록 수정
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new CustomApiException("This Order ID does not exist."));

    if (order.getIsDeleted()) {
      throw new CustomApiException("This order has been deleted.");
    }

    return new OrderResponseDto(order);
  }

  public PagedModel<OrderResponseDto> getOrdersPage(
      List<UUID> uuidList, Predicate predicate, Pageable pageable) {

    // TODO 본인 주문만 조회되도록 수정
    Page<OrderResponseDto> orderResponseDtoPage = orderRepository.findAllToPage(uuidList, predicate,
        pageable);

    return new PagedModel<>(orderResponseDtoPage);
  }

  @Transactional
  @CircuitBreaker(name = "OrderService", fallbackMethod = "handleOrderFailue")
  public OrderResponseDto updateOrder(UUID orderId, OrderRequestDto orderRequestDto) {

    // TODO 본인 주문만 수정 가능하도록
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new CustomApiException("This Order ID does not exist."));

    if (order.getIsDeleted()) {
      throw new CustomApiException("This order has been deleted.");
    }

    // TODO 이미 배송중이라면 수정 불가

    Long totalPrice = null;
    if (orderRequestDto.getProductQuantity() != null) {
      ProductResponseDto product = productService.getProductDtoByProductId(
          orderRequestDto.getProductId());
      totalPrice = product.getPrice() * orderRequestDto.getProductQuantity();
      if (product.getCount() < orderRequestDto.getProductQuantity() - order.getProductQuantity()) {
        throw new CustomApiException("추가 주문시 재고보다 주문 수량이 많습니다.");
      }
      // TODO 이전 주문과 비교하여 재고 차감
    }

    // TODO 수정자 추가
    order.update(
        orderRequestDto.getProductId(),
        orderRequestDto.getSupplyCompanyId(),
        orderRequestDto.getReceiveCompanyId(),
        orderRequestDto.getProductQuantity(),
        orderRequestDto.getOrderRequest(),
        totalPrice
    );

    return new OrderResponseDto(order);
  }


  public OrderResponseDto handleOrderFailue(OrderRequestDto orderRequestDto, Throwable t) {
    return new OrderResponseDto(t.getMessage());
  }
}
