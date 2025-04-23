package com.reki.seu_blog.config.jpa;

import org.springframework.data.domain.AuditorAware;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || !(auth.getPrincipal() instanceof Jwt)) {
            return Optional.of("anonymous");
        }

        Jwt jwt = (Jwt) auth.getPrincipal();
        return Optional.of(jwt.getId());
//        return Optional.of("reki");
    }
}
