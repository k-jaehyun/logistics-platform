package com.logistics.platform.slack_service.application.service.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

@Service
public class MessageServiceImpl implements MessageService {

  @Value("${slack.bot.token}")
  private String botToken;

  private final RestTemplate restTemplate;

  public MessageServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public void sendMessageToUser(String userSlackId, String message) {
    String url = "https://slack.com/api/chat.postMessage";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(botToken);

    String payload = String.format(
        "{\"channel\": \"%s\", \"text\": \"%s\"}",
        userSlackId,
        message
    );

    HttpEntity<String> request = new HttpEntity<>(payload, headers);
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

    if (!response.getStatusCode().is2xxSuccessful()) {
      throw new RuntimeException("Failed to send message: " + response.getBody());
    }
  }

  // Email로 SlackID 가져오는 코드
//  public String getUserSlackIdByEmail(String email) {
//    String url = "https://slack.com/api/users.lookupByEmail";
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.setBearerAuth(botToken);
//
//    HttpEntity<String> request = new HttpEntity<>(headers);
//    String apiUrl = String.format("%s?email=%s", url, email);
//
//    ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, request, String.class);
//
//    // Parse response to extract user ID
//    if (response.getStatusCode().is2xxSuccessful()) {
//      // JSON Parsing logic to extract "user.id" from response
//    } else {
//      throw new RuntimeException("Failed to fetch user ID for email: " + email);
//    }
//  }

}

