package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.UserRegistrationDtoRequest;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {
    @Mock
    private AuthenticationServiceImpl underTest;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    @Mock
    private UsersRepository usersRepository;
    @Mock
    private JWTService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    /*@BeforeEach
    void setUp() {
        underTest = new AuthenticationServiceImpl(usersRepository,jwtService,passwordEncoder,authenticationManager);
    }*/
    @Test
    void canSave(){
        Users user = Users.builder()
                .email("ab@gmail.com")
                .createdAt(LocalDateTime.now())
                .password("123")
                .address("abc")
                .build();
        underTest.save(user);
        ArgumentCaptor<Users> usersArgumentCaptor = ArgumentCaptor.forClass(Users.class);
        verify(underTest).save(usersArgumentCaptor.capture());
        Users capturedUser = usersArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }
    @Test
    void canRegistrate() {
    }

    @Test
    void authenticate() {
    }
}