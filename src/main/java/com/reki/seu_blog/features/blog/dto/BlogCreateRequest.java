package com.reki.seu_blog.features.blog.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record BlogCreateRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Content is required")
        String content,

        @NotBlank(message = "Cover is required")
        String cover,

        @NotNull(message = "Slug is required")
        Set<String> categories
) {
}
