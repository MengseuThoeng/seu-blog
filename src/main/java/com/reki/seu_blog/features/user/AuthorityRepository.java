package com.reki.seu_blog.features.user;

import com.reki.seu_blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
