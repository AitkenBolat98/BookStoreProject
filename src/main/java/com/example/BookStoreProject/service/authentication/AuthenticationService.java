package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;

public interface AuthenticationService {

    UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request);

    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request);

}
