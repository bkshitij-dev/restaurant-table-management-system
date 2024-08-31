package com.example.rtms.service;

import com.example.rtms.dto.request.LoginRequestDto;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.model.User;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
public interface AuthenticationService {

    void register(UserRequestDto request);

    User login(LoginRequestDto request);
}
