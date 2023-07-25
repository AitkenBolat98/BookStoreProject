package com.example.BookStoreProject.dto.request.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDtoRequest {
    @NotBlank(message = "the email field can not be blank")
    private String email;
    @NotBlank(message = "the password field can not be blank")
    private String password;
}
