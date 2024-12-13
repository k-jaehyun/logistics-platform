package com.logistics.platform.slack_service.application.service.message;

public interface MessageService {

  void sendMessageToUser(String userSlackId, String message);

}
