package com.example.BookStoreProject.dto.request.authentication;

import com.example.BookStoreProject.security.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
