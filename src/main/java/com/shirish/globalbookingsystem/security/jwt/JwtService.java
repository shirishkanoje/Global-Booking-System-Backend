package com.shirish.globalbookingsystem.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtUtil jwtUtil;

    public String generateToken(String username) {

        return jwtUtil.generateToken(username);
    }

    public String extractUsername(String token) {

        return jwtUtil.extractUsername(token);
    }

    public boolean validateToken(String token) {

        return jwtUtil.isTokenValid(token);
    }
}