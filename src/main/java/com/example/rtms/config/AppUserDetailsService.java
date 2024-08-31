package com.example.rtms.config;

import com.example.rtms.model.User;
import com.example.rtms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * @author Kshitij
 * @created 30-Aug-2024
 */

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for user: "
                        + emailOrUsername));
        return AppUserDetails.build(user);
    }
}
