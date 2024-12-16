package com.logistics.platform.deliverymanagerservice.application.service;

import com.logistics.platform.deliverymanagerservice.application.dto.UserDto;
import com.logistics.platform.deliverymanagerservice.infrastructure.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSerivce {

  private final UserClient userClient;

//  @Override
//  public boolean checkIfUserExists(Long userId) {
//    return userClient.checkIfUserExists(userId);
//  }

  @Override
  public UserDto getUserInfo(String userName, String userRole) {
    return userClient.getUserInfo(userName, userRole);
  }
}
