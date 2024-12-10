package com.logistics.platform.hub_service.presentation.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class HubCreateRequest {

  @NotEmpty
  private String hubName;

  @NotEmpty
  @Pattern(regexp = "\\d{5}", message = "주소는 5자리 숫자 우편번호 형식이어야 합니다.")
  private String address;

}
