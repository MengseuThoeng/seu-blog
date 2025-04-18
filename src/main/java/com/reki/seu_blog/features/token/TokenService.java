package com.reki.seu_blog.features.token;

import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import org.springframework.security.core.Authentication;

public interface TokenService {

    AuthenticationResponse createToken(Authentication auth);

    String createAccessToken(Authentication auth , String username);

    String createRefreshToken(Authentication auth , String username);

}
