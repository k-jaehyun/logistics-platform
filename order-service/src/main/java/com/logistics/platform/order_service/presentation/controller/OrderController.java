package com.logistics.platform.order_service.presentation.controller;

import com.logistics.platform.order_service.application.service.OrderService;
import com.logistics.platform.order_service.presentation.global.ResponseDto;
import com.logistics.platform.order_service.presentation.request.OrderRequestDto;
import com.logistics.platform.order_service.presentation.response.OrderResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping // TODO createOrder 권한 검증
  public ResponseDto<OrderResponseDto> createOrder(
      @Valid @RequestBody OrderRequestDto orderRequestDto) {

    OrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);

    if (orderResponseDto.getMessage() == null) {
      return new ResponseDto<>(ResponseDto.SUCCESS, "주문이 생성되었습니다.", orderResponseDto);
    } else {
      return new ResponseDto<>(ResponseDto.FAILURE, orderResponseDto.getMessage());
    }
  }


}
