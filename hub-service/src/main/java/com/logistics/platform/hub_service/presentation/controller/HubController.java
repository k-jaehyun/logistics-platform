package com.logistics.platform.hub_service.presentation.controller;

import com.google.maps.errors.ApiException;
import com.logistics.platform.hub_service.application.service.HubService;
import com.logistics.platform.hub_service.presentation.global.ResponseDto;
import com.logistics.platform.hub_service.presentation.request.HubCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubResponse;
import jakarta.validation.Valid;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hubs")
@RequiredArgsConstructor
public class HubController {

  private final HubService hubService;

  @PostMapping
  public ResponseDto<HubResponse> create(@RequestBody @Valid HubCreateRequest hubCreateRequest)
      throws IOException, InterruptedException, ApiException {
    HubResponse hubResponse = hubService.createHub(hubCreateRequest);
    return new ResponseDto<>(ResponseDto.SUCCESS, "허브가 생성되었습니다.", hubResponse);
  }

  //@GetMapping("/{hubId}")

  @GetMapping
  public Page<HubResponse> search(String keyword, Pageable pageable) {
    return hubService.searchHubs(keyword, pageable);
  } 




}
