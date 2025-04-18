package com.reki.seu_blog.security;

import com.reki.seu_blog.domain.User;
import com.reki.seu_blog.features.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: {}", username);
        User user = userRepository.findByUsernameAndIsEnabledTrueAndEmailVerifiedTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));


        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);

        System.out.println(customUserDetails.getUsername());

        return customUserDetails;
    }
}
