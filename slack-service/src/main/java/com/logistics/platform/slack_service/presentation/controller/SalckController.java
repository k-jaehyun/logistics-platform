package com.logistics.platform.slack_service.presentation.controller;

import com.logistics.platform.slack_service.application.service.slack.SlackService;
import com.logistics.platform.slack_service.common.ResponseDto;
import com.logistics.platform.slack_service.presentation.request.SlackRequestDto;
import com.logistics.platform.slack_service.presentation.response.SlackResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/slacks")
public class SalckController {

  private final SlackService slackService;

  @PostMapping
  public ResponseDto<SlackResponseDto> createMessage(
      @RequestBody SlackRequestDto slackRequestDto,
      @RequestHeader(value = "X-User-Name") String userName
  ) {
    RequestContextHolder.getRequestAttributes();

    SlackResponseDto slackResponseDto = slackService.createMessage(slackRequestDto, userName);

    return new ResponseDto<>(ResponseDto.SUCCESS, "메제지가 발송되었습니다.", slackResponseDto);
  }

}
