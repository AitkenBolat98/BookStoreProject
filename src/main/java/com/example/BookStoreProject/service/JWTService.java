package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Token;
import com.example.BookStoreProject.module.Users;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public interface JWTService {
    Key getSignInKey();
    Claims extractAllClaims(String token);

    String extractUsername(String jwt);
    <T> T extractClaim(String token, Function<Claims,T> claimsResolver);
    String generateToken(Map<String,Object> extraClaims, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token,UserDetails userDetails);
    Token save(Token token);
    void revokeAllUserTokens(Users user);
    Optional<Token> getByToken(String token);
}
