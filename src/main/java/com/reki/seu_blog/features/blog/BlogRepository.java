package com.reki.seu_blog.features.blog;

import com.reki.seu_blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Boolean existsBySlug(String existingSlug);
}
