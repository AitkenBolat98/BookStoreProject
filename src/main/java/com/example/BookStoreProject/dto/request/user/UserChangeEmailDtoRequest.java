package com.example.BookStoreProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserChangeEmailDtoRequest {
    @NotBlank(message = "the new Email field can not be blank")
    private String newEmail;
}

