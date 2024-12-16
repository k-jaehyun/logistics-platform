package com.logistics.platform.deliverymanagerservice.application.service;

import com.logistics.platform.deliverymanagerservice.application.dto.UserDto;

public interface UserSerivce {

  // boolean checkIfUserExists(Long userId);

  UserDto getUserInfo(String userName, String userRole);

}
