package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request);
    UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request);
    void changePassword(UserChangePasswordDtoRequest request,String token);
}
