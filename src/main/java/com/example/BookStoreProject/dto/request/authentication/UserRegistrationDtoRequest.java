package com.example.BookStoreProject.dto.request.authentication;

import com.example.BookStoreProject.security.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationDtoRequest {
    @NotBlank(message = "the email field can not be blank")
    private String email;
    @ValidPassword
    private String password;
    @NotBlank(message = "the name field can not be blank")
    private String name;

    private String address;
    @NotBlank(message = "the role field can not be blank")
    private String role;

}
