package com.example.rtms.service.impl;

import com.example.rtms.model.Role;
import com.example.rtms.repository.RoleRepository;
import com.example.rtms.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
