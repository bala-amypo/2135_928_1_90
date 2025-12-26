package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "mySuperSecretKeyForJwtTokenGeneration12345";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 hours

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Generate JWT Token
    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .addClaims(Map.of(
                        "userId", userId,
                        "role", role
                ))
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_TIME)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate token and return claims
    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract Email
    public String extractEmail(String token) {
        return validateToken(token).getSubject();
    }

    // Extract Role
    public String extractRole(String token) {
        return validateToken(token).get("role", String.class);
    }

    // Extract User ID
    public Long extractUserId(String token) {
        return validateToken(token).get("userId", Long.class);
    }
}
