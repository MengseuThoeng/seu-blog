package com.reki.seu_blog.features.auth;

import com.reki.seu_blog.domain.User;
import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import com.reki.seu_blog.features.auth.dto.LoginRequest;
import com.reki.seu_blog.features.auth.dto.RefreshTokenRequest;
import com.reki.seu_blog.features.token.TokenService;
import com.reki.seu_blog.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserDetailsService userDetailsService;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final TokenService tokenService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final JwtDecoder refreshJwtDecoder;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(loginRequest.username());
        User user = customUserDetails.getUser();
//        if (user.getIsDeleted()) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User account has been deleted.");
//        }

        // Check if the user's email is verified
//        if (!user.getIsVerified()) {
//            throw new ResponseStatusException(
//                    HttpStatus.UNAUTHORIZED,
//                    "User email has not been verified. Please verify your email."
//            );
//        }

        // Proceed with authentication
        Authentication auth = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        auth = daoAuthenticationProvider.authenticate(auth);

//        // Login at
//        user.setLoggedInAt(LocalDateTime.now());
//        userRepository.save(user);

        // Create tokens
        String accessToken = tokenService.createAccessToken(auth, user.getUsername());
        String refreshToken = tokenService.createRefreshToken(auth, user.getUsername());

        // Map roles to RoleNameResponse
//        List<RoleNameResponse> roles = user.getRoles().stream()
//                .map(role -> new RoleNameResponse(role.getName()))
//                .collect(Collectors.toList());

        // Create UserResponse

        // Create AuthenticationResponse
        return new AuthenticationResponse(accessToken, refreshToken);
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
//        try {
//            Authentication auth = new BearerTokenAuthenticationToken(refreshTokenRequest.refreshToken());
//            System.out.println("Still not working");
//            auth = jwtAuthenticationProvider.authenticate(auth);
//            // Extract the issuer from the refresh token
//            String issuer = ((Jwt) auth.getPrincipal()).getId();
//
//            // Create a new access token using the issuer from the refresh token
//            String newAccessToken = tokenService.createAccessToken(auth, issuer);
//
//            // Create a new refresh token using the issuer from the refresh token
//            String newRefreshToken = tokenService.createRefreshToken(auth, issuer);
//
//            return new AuthenticationResponse(newAccessToken, newRefreshToken);
//        } catch (JwtException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Refresh token authentication failed", e);
//        }
        try {
            Jwt jwt = refreshJwtDecoder.decode(refreshTokenRequest.refreshToken());
            Authentication auth = new JwtAuthenticationToken(jwt);

            String issuer = jwt.getId(); // Or jwt.getClaim("iss")

            String newAccessToken = tokenService.createAccessToken(auth, issuer);
            String newRefreshToken = tokenService.createRefreshToken(auth, issuer);

            return new AuthenticationResponse(newAccessToken, newRefreshToken);
        } catch (JwtException e) {
            e.printStackTrace();
            throw new RuntimeException("Refresh token authentication failed", e);
        }


    }
}
