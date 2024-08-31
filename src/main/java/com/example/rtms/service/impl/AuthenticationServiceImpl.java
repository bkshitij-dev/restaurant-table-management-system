package com.example.rtms.service.impl;

import com.example.rtms.constant.AppConstants;
import com.example.rtms.dto.request.LoginRequestDto;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.exception.AppException;
import com.example.rtms.model.Role;
import com.example.rtms.model.User;
import com.example.rtms.repository.UserRepository;
import com.example.rtms.service.AuthenticationService;
import com.example.rtms.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleService roleService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public void register(UserRequestDto request) {
        if (existsByEmailOrUsername(request.getEmail(), request.getUsername())) {
            throw new AppException("User already exists");
        }
        createUser(request, List.of(AppConstants.ROLE_CUSTOMER));
    }

    @Override
    public void createUser(UserRequestDto request, List<String> roles) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        roles.forEach(role -> {
            user.addRole(roleService.findOrCreateByName(role));
        });
        userRepository.save(user);
    }

    public User login(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmailOrUsername(), request.getPassword()));
        return userRepository.findByEmailOrUsername(request.getEmailOrUsername())
                .orElseThrow();
    }

    public Long count() {
        return userRepository.count();
    }

    private boolean existsByEmailOrUsername(String email, String username) {
        return userRepository.existsByEmailOrUsername(email, username);
    }
}
