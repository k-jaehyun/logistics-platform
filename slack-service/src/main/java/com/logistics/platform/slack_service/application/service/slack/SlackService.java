package com.logistics.platform.slack_service.application.service.slack;

import com.logistics.platform.slack_service.common.exception.CustomApiException;
import com.logistics.platform.slack_service.domain.model.Slack;
import com.logistics.platform.slack_service.domain.repository.SlackRepository;
import com.logistics.platform.slack_service.presentation.request.SlackRequestDto;
import com.logistics.platform.slack_service.presentation.response.SlackResponseDto;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
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

  public SlackResponseDto getMessage(UUID slackId, String role) {

    if (!role.equals("ROLE_MASTER")) { // TODO Auth 서버에서 권한 검증
      throw new CustomApiException("Master 권한만 조회 할 수 있습니다.");
    }

    Slack slack = slackRepository.findById(slackId)
        .orElseThrow(() -> new CustomApiException("Check Slack ID. No exist."));

    return new SlackResponseDto(slack);
  }

  public PagedModel<SlackResponseDto> getSlacksPage(List<UUID> uuidList, Predicate predicate,
      Pageable pageable,
      String role) {

    if (!role.equals("ROLE_MASTER")) { // TODO Auth 서버에서 권한 검증
      throw new CustomApiException("Master 권한만 조회 할 수 있습니다.");
    }

    Page<SlackResponseDto> slackResponseDtoPage = slackRepository.findAllToPage(uuidList, predicate,
        pageable);

    return new PagedModel<>(slackResponseDtoPage);
  }
}
