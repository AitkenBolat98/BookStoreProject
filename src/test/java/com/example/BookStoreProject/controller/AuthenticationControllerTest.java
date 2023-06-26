package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.UserRegistrationDtoResponse;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.AuthenticationService;
import com.example.BookStoreProject.service.AuthenticationServiceImpl;
import com.example.BookStoreProject.service.JWTService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthenticationController.class)
class AuthenticationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    AuthenticationService authenticationService;
    @MockBean
    UsersRepository usersRepository;
    @MockBean
    JWTService jwtService;
    @MockBean
    AuthenticationManager authenticationManager;
    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;
    AuthenticationServiceImpl authenticationServiceImpl = new
            AuthenticationServiceImpl(usersRepository,jwtService,bCryptPasswordEncoder,authenticationManager);

    @Test
    void registration() throws Exception {

    }

    @Test
    void authenticate() {
    }
}