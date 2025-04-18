package com.reki.seu_blog.features.auth.dto;


public record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {
}
