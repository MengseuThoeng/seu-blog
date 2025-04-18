package com.reki.seu_blog.features.token;

import com.reki.seu_blog.features.auth.AuthService;
import com.reki.seu_blog.features.auth.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {


    private final JwtEncoder jwtEncoder;
    private final JwtEncoder refreshJwtEncoder;

    @Override
    public AuthenticationResponse createToken(Authentication auth) {
        return null;
    }

    @Override
    public String createAccessToken(Authentication auth , String username) {
        String scope = "";

        if (auth.getPrincipal() instanceof Jwt jwt) {
            scope = jwt.getClaimAsString("scope");
        } else {
            scope = auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .filter(authority -> !authority.startsWith("ROLE_"))
                    .collect(Collectors.joining(" "));
        }

        Instant now = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .id(username)
                .subject("Access Resource")
                .audience(List.of("WEB"))
                .issuedAt(now)
                .expiresAt(now.plus(5, ChronoUnit.MINUTES))
                .issuer(username)  // Use the issuer from the refresh token
                .claim("scope", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

    @Override
    public String createRefreshToken(Authentication auth, String username) {
        String scope = "";

        if (auth.getPrincipal() instanceof Jwt jwt) {
            scope = jwt.getClaimAsString("scope");
        } else {
            scope = auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .filter(authority -> !authority.startsWith("ROLE_"))
                    .collect(Collectors.joining(" "));
        }

        Instant now = Instant.now();
        JwtClaimsSet refreshJwtClaimsSet = JwtClaimsSet.builder()
                .id(username)
                .subject("Refresh Resource")
                .audience(List.of("WEB"))
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .issuer(username)  // Use the issuer from the refresh token
                .claim("scope", scope)
                .build();

        return refreshJwtEncoder.encode(JwtEncoderParameters.from(refreshJwtClaimsSet)).getTokenValue();
    }


}
