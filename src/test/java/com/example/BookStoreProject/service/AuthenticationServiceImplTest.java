package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.authentication.AuthenticationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    private AuthenticationServiceImpl underTest;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    @Mock
    private UsersRepository usersRepository;
    @Mock
    private JWTService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserRegistrationDtoRequest request;
    @InjectMocks
    private Users user;
   @BeforeEach
    void setUp() {
       underTest = new AuthenticationServiceImpl(usersRepository, jwtService, passwordEncoder, authenticationManager);
   }
    @Test
    void canSave(){
        underTest.save(user);
        ArgumentCaptor<Users> usersArgumentCaptor = ArgumentCaptor.forClass(Users.class);
        verify(usersRepository).save(usersArgumentCaptor.capture());
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