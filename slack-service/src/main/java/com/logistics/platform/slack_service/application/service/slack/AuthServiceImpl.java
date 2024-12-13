package com.logistics.platform.slack_service.application.service.slack;

import com.logistics.platform.slack_service.presentation.client.AuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthClient authClient;

  @Override
  public String getSlackIdByUsername(String username) {
    return authClient.getSlackIdByUsername(username);
  }
}
