package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.module.ResetPassword;

public interface UserResetPasswordService {
    UserPasswordResetDtoResponse resetPassword(UserPasswordResetDtoRequest request);
    ResetPassword getByToken(String token);
    boolean isValid(String token);
}
