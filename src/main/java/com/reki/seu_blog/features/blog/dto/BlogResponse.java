package com.reki.seu_blog.features.blog.dto;

import java.util.Set;

public record BlogResponse(
    String title,

    String content,

    String cover,

    String slug,

    String  createdBy,

    String createdAt,

    Set<String> categories
) {
}
