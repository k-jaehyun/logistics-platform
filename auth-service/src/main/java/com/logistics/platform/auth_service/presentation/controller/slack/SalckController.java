package com.logistics.platform.auth_service.presentation.controller.slack;

import com.logistics.platform.auth_service.application.service.slack.SlackService;
import com.logistics.platform.auth_service.common.ResponseDto;
import com.logistics.platform.auth_service.presentation.request.slack.SlackRequestDto;
import com.logistics.platform.auth_service.presentation.response.slack.SlackResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      @RequestBody @Valid SlackRequestDto slackRequestDto,
      UserDetails userDetails
  ) {
    RequestContextHolder.getRequestAttributes();

    SlackResponseDto slackResponseDto = slackService.createMessage(slackRequestDto, userDetails);

    return new ResponseDto<>(ResponseDto.SUCCESS, "메제지가 발송되었습니다.", slackResponseDto);
  }

}
