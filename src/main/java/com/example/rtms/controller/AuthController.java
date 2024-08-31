package com.example.rtms.controller;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

import com.example.rtms.config.AppUserDetails;
import com.example.rtms.constant.AppConstants;
import com.example.rtms.dto.request.LoginRequestDto;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.dto.response.ApiResponse;
import com.example.rtms.dto.response.LoginResponseDto;
import com.example.rtms.model.User;
import com.example.rtms.service.AuthenticationService;
import com.example.rtms.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRequestDto request) {
        authenticationService.register(request);
        return new ResponseEntity<>(successResponse(AppConstants.SUCCESS_SAVE), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequestDto request) {
        User authenticatedUser = authenticationService.login(request);
        String jwtToken = jwtService.generateToken(AppUserDetails.build(authenticatedUser));
        LoginResponseDto loginResponse = LoginResponseDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
        return new ResponseEntity<>(successResponse(AppConstants.SUCCESS_RETRIEVE, loginResponse), HttpStatus.OK);
    }
}
