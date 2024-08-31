package com.example.rtms.service;

import com.example.rtms.dto.request.LoginRequestDto;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.model.User;

import java.util.List;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
public interface AuthenticationService {

    void register(UserRequestDto request);

    void createUser(UserRequestDto request, List<String> roles);

    User login(LoginRequestDto request);

    Long count();
}
