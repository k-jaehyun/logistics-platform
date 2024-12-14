package com.logistics.platform.slack_service.application.service.message;

public interface MessageService {

  String sendMessageToUser(String userSlackId, String message);


}
