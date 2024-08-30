package com.example.rtms.controller;

/*
 * @author Kshitij
 * @created 30-Aug-2024
 */

import com.example.rtms.constant.AppConstants;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.dto.response.ApiResponse;
import com.example.rtms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody UserRequestDto request) {
        userService.register(request);
        return new ResponseEntity<>(successResponse(AppConstants.SUCCESS_SAVE), HttpStatus.OK);
    }

    @GetMapping("/postman")
    public String postman() {
        return "postman";
    }
}
