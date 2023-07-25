package com.example.BookStoreProject.dto.request.user;

import com.example.BookStoreProject.security.ValidPassword;
import lombok.Getter;

@Getter
public class UserChangePasswordDtoRequest {
    @ValidPassword
    private String newPassword;
    @ValidPassword
    private String confirmPassword;
}
