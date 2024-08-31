package com.example.rtms.service;

import com.example.rtms.model.Role;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
public interface RoleService {

    Role findOrCreateByName(String name);
}
