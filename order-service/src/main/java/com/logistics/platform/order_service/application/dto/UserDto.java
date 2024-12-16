package com.logistics.platform.order_service.application.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private UUID userId;

  private String userName;

  private String userRole;

  private String slackId;

}
