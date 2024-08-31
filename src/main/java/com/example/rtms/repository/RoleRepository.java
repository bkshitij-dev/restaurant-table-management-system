package com.example.rtms.repository;

import com.example.rtms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
    Role findByName(String name);
}
