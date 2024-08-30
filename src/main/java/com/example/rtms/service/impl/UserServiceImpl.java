package com.example.rtms.service.impl;

import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.exception.AppException;
import com.example.rtms.model.User;
import com.example.rtms.repository.UserRepository;
import com.example.rtms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRequestDto request) {
        if (existsByEmailOrUsername(request.getEmail(), request.getUsername())) {
            throw new AppException("User already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    private boolean existsByEmailOrUsername(String email, String username) {
        return userRepository.existsByEmailOrUsername(email, username);
    }
}
