package com.logistics.platform.slack_service.application.service.slack;

import com.logistics.platform.slack_service.domain.model.Slack;
import com.logistics.platform.slack_service.domain.repository.SlackRepository;
import com.logistics.platform.slack_service.presentation.request.SlackRequestDto;
import com.logistics.platform.slack_service.presentation.response.SlackResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlackService {

  private final SlackRepository slackRepository;
  private final AuthService authService;

  public SlackResponseDto createMessage(SlackRequestDto slackRequestDto, String username) {

    String senderSlackId = authService.getSlackIdByUsername(username);

    Slack slack = new Slack(
        senderSlackId,
        slackRequestDto.getReceiverSlackId(),
        slackRequestDto.getContent(),
        username
    );

    // TODO 실제 앱 연동

    slackRepository.save(slack);

    return new SlackResponseDto(slack);
  }
}
