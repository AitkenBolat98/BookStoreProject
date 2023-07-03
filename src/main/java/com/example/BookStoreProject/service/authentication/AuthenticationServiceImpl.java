package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.EmailService;
import com.example.BookStoreProject.service.JWTService;
import com.example.BookStoreProject.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsersRepository usersRepository;

    private final JWTService jwtService;

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;
    public Users save(Users user){
        return usersRepository.save(user);
    }

    @Override
    public UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request) {
        var user = Users.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .build();
        this.save(user);
        var jwtToken = jwtService.generateToken(user);
        return UserRegistrationDtoResponse.builder()
                .email(user.getEmail())
                .address(user.getAddress())
                .jwt(jwtToken)
                .build();

    }

    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) {
        authenticationManager.authenticate((
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
                )
        );
        var user = usersRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDtoResponse.builder()
                .email(request.getEmail())
                .jwt(jwtToken)
                .build();
    }



}
