package com.reki.seu_blog.features.auth;

import com.reki.seu_blog.domain.User;
import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import com.reki.seu_blog.features.auth.dto.LoginRequest;
import com.reki.seu_blog.features.token.TokenService;
import com.reki.seu_blog.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserDetailsService userDetailsService;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final TokenService tokenService;

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
}
