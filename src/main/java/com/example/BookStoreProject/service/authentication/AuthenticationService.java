package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request);
    void changePassword(UserChangePasswordDtoRequest request,String token);
}
