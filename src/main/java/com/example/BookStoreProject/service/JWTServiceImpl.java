package com.example.BookStoreProject.service;

import com.example.BookStoreProject.constants.SecurityConstants;
import com.example.BookStoreProject.module.Token;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService{
    private final TokenRepository tokenRepository;

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    @Override
    public Token save(Token token){
        return tokenRepository.save(token);
    }
    @Override
    public void revokeAllUserTokens(Users user){
        var ValidUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if(ValidUserTokens.isEmpty()){
            return;
        }
        ValidUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(ValidUserTokens);
    }

    @Override
    public Optional<Token> getByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public String extractUsername(String jwt) {
        return extractClaim(jwt,Claims::getSubject);
    }

    public Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SecurityConstants.JWT_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}

