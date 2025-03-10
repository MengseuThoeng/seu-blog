package com.reki.seu_blog.features.blog.dto;

import java.util.Set;

public record BlogResponse(
    String title,

    String content,

    String cover,

    Set<String> categories
) {
}
