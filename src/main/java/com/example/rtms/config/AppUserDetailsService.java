package com.example.rtms.config;

import com.example.rtms.model.User;
import com.example.rtms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author Kshitij
 * @created 30-Aug-2024
 */

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for user: " + username));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
