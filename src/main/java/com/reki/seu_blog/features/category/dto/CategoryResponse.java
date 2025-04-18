package com.reki.seu_blog.features.category.dto;

import com.reki.seu_blog.domain.Blog;
import jakarta.persistence.*;

import java.util.Set;

public record CategoryResponse(
        String name,

        String description,

        Boolean isDeleted
) {
}

