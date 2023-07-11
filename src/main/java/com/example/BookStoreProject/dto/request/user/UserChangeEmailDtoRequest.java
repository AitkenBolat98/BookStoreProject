package com.example.BookStoreProject.dto.request.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserChangeEmailDtoRequest {
    @NotNull
    private String newEmail;
}

