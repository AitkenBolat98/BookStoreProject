package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.authentication.RegistrationService;
import com.example.BookStoreProject.service.authentication.RegistrationServiceImpl;
import com.example.BookStoreProject.service.JWTService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AuthenticationController.class)
class AuthenticationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    UsersRepository usersRepository;
    @MockBean
    JWTService jwtService;
    @MockBean
    AuthenticationManager authenticationManager;
    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;
    RegistrationServiceImpl registrationServiceImpl = new
            RegistrationServiceImpl(usersRepository,jwtService,bCryptPasswordEncoder,authenticationManager);

    @Test
    void registration() throws Exception {

    }

    @Test
    void authenticate() {
    }
}