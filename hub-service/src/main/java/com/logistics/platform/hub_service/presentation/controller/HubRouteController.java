package com.logistics.platform.hub_service.presentation.controller;

import com.logistics.platform.hub_service.application.service.HubRouteService;
import com.logistics.platform.hub_service.presentation.global.ResponseDto;
import com.logistics.platform.hub_service.presentation.request.HubRouteCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubRouteResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hubRoutes")
@RequiredArgsConstructor
public class HubRouteController {
  private final HubRouteService hubRouteService;

  @PostMapping
  public ResponseDto<HubRouteResponse> create(@RequestBody @Valid HubRouteCreateRequest hubRouteCreateRequest) {
    HubRouteResponse hubRouteResponse = hubRouteService.createHubRoute(hubRouteCreateRequest);
    return new ResponseDto<>(ResponseDto.SUCCESS, "허브 배송 경로가 생성되었습니다.", hubRouteResponse);
  }
}
