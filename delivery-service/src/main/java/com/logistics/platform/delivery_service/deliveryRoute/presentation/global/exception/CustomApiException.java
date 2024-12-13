package com.logistics.platform.delivery_service.deliveryRoute.presentation.global.exception;

public class CustomApiException extends RuntimeException{
  public CustomApiException(String message) {
    super(message);
  }

}
