package com.logistics.platform.order_service.application.service;

import com.logistics.platform.order_service.application.dto.UserDto;

public interface UserSerivce {


  UserDto getUserInfo(String userName, String userRole);
}
