package com.logistics.platform.deliverymanagerservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private Long userId;

  private String userName;

  private String role;

  private String slackId;

}
