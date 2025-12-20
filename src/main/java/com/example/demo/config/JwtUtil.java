package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Token validity: 1 hour
    private static final long JWT_TOKEN_VALIDITY = 60 * 60 * 1000;

    // Secret key (must be at least 256 bits for HS256)
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // =========================
    // Generate Token
    // =========================
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(key)
                .compact();
    }

    // =========================
    // Extract Username
    // =========================
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // =========================
    // Extract Expiration
    // =========================
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // =========================
    // Extract Any Claim
    // =========================
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // =========================
    // Validate Token
    // =========================
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // =========================
    // Helpers
    // =========================
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
