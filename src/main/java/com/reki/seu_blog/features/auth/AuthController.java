package com.reki.seu_blog.features.auth;

import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import com.reki.seu_blog.features.auth.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    AuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("Login Request: " + loginRequest);
        return authService.login(loginRequest);
    }


}
