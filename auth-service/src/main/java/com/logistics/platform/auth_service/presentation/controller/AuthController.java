package com.logistics.platform.auth_service.presentation.controller;

import com.logistics.platform.auth_service.application.dto.CustomUserDetails;
import com.logistics.platform.auth_service.application.dto.SignupResDto;
import com.logistics.platform.auth_service.application.dto.UserResDto;
import com.logistics.platform.auth_service.application.service.AuthService;
import com.logistics.platform.auth_service.common.ResponseDto;
import com.logistics.platform.auth_service.presentation.request.SignupReqDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseDto<SignupResDto> signup(@RequestBody @Valid SignupReqDto reqDto) {
        return new ResponseDto<>(ResponseDto.SUCCESS, "회원가입되었습니다.", authService.signup(reqDto));
    }

    @GetMapping("/validate")
    public UserResDto userCheck(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return authService.getUser(customUserDetails.getUserId());
    }

}
