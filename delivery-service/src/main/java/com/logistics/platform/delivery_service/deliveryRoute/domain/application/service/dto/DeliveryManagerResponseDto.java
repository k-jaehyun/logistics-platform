package com.logistics.platform.delivery_service.deliveryRoute.domain.application.service.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryManagerResponseDto {

  private UUID deliveryManagerId;       // 배송담당자 ID
  // private String managerName;   // 배송담당자 이름
  // private String status;     // 배정 가능 여부를 위한 상태(배정가능/배송중)

}
