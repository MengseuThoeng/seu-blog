package com.reki.seu_blog.features.auth;

import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import com.reki.seu_blog.features.auth.dto.LoginRequest;
import com.reki.seu_blog.features.auth.dto.RefreshTokenRequest;

public interface AuthService {

    AuthenticationResponse login(LoginRequest loginRequest);

    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
