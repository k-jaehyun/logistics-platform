package com.logistics.platform.hub_service.presentation.controller;

import com.logistics.platform.hub_service.application.service.HubRouteService;
import com.logistics.platform.hub_service.presentation.request.HubRouteCreateRequest;
import com.logistics.platform.hub_service.presentation.response.HubRouteCreateResponse;
import jakarta.validation.Valid;
import java.util.List;
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
  public List<HubRouteCreateResponse> create(
      @RequestBody @Valid HubRouteCreateRequest hubRouteCreateRequest) {
    return hubRouteService.createHubRoute(hubRouteCreateRequest);
  }
}
