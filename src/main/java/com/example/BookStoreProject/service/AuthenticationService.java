package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.UserRegistrationDtoResponse;

public interface AuthenticationService {

    UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request);

    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request);
}
