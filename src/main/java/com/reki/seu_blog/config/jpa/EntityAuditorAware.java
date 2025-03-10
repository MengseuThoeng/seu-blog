package com.reki.seu_blog.config.jpa;

import org.springframework.data.domain.AuditorAware;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null || !auth.isAuthenticated() || !(auth.getPrincipal() instanceof Jwt)) {
//            return Optional.empty();
//        }
//
//        Jwt jwt = (Jwt) auth.getPrincipal();
//        return Optional.of(jwt.getId());
        return Optional.of("reki");
    }
}
