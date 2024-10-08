package com.example.rtms.config;

import com.example.rtms.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
@Data
@AllArgsConstructor
public class AppUserDetails implements UserDetails {

    private Long id;

    private String name;

    private String email;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static AppUserDetails build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new AppUserDetails(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public List<String> getRoleNames() {
        return this.authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }
}
