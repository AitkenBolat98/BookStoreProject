package com.example.BookStoreProject.dto.request.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserPasswordResetDtoRequest {
    @NotBlank(message = "the email field can not be blank")
    private String email;
}
