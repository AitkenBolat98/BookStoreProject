package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.constants.TokenType;
import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;
import com.example.BookStoreProject.module.ResetPassword;
import com.example.BookStoreProject.module.Token;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.JWTService;
import com.example.BookStoreProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserResetPasswordService userResetPasswordService;
    private final JWTService jwtService;
    public Users save(Users user){
        return usersRepository.save(user);
    }
    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) {
        Authentication authObject;
        try {
            authObject = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (request.getEmail(),request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BadCredentialsException("Credentials Invalid");
        }
        Users user = userService.getByUserEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        jwtService.revokeAllUserTokens(user);
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        jwtService.save(token);
        return AuthenticationDtoResponse
                .builder()
                .jwt(token.getToken())
                .build();
    }
    @Override
    public UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request) {
        var user = Users.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .name(request.getName())
                .build();
        this.save(user);
        var jwtToken = jwtService.generateToken(user);
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        jwtService.save(token);
        return UserRegistrationDtoResponse.builder()
                .email(user.getEmail())
                .address(user.getAddress())
                .jwt(token.getToken())
                .build();
    }
    @Override
    public void changePassword(UserChangePasswordDtoRequest request, String token) {
        ResetPassword resetPassword = userResetPasswordService.getByToken(token);
        Users user = resetPassword.getUser();
        if(user != null){
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userService.save(user);
        }else{
            throw new RuntimeException("User not found");
        }
    }

}
