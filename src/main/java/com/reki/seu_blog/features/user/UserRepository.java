package com.reki.seu_blog.features.user;

import com.reki.seu_blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndIsEnabledTrueAndEmailVerifiedTrue(String username);
}
