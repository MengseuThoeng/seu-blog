package com.reki.seu_blog.features.blog;

import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Boolean existsBySlug(String existingSlug);

    Optional<Blog> findBySlug(String slug);
}
