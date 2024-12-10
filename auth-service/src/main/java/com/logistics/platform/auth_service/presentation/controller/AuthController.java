package com.logistics.platform.auth_service.presentation.controller;

import com.logistics.platform.auth_service.application.dto.SignupResDto;
import com.logistics.platform.auth_service.application.service.AuthService;
import com.logistics.platform.auth_service.presentation.request.SignupReqDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SignupResDto> signup(@RequestBody @Valid SignupReqDto reqDto) {
        // TODO 응답 형식 논의 후 수정하기 - 에러 로직 포함
        return ResponseEntity.status(HttpStatus.OK).body(authService.signup(reqDto));
    }

}
