package com.example.BookStoreProject.dto.request.authentication;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserPasswordResetDtoRequest {
    @NotNull
    private String email;
}
