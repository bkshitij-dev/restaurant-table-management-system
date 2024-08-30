package com.example.rtms.repository;

/*
 * @author Kshitij
 * @created 30-Aug-2024
 */

import com.example.rtms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailOrUsername(String email, String username);

    @Query(value = "SELECT EXISTS (\n" +
            "    SELECT 1\n" +
            "    FROM users\n" +
            "    WHERE email = ?1 OR username = ?2\n" +
            ")", nativeQuery = true)
    boolean existsByEmailOrUsername(String email, String username);
}
