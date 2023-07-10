package com.example.BookStoreProject.dto.request.authentication;

import com.example.BookStoreProject.security.ValidPassword;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRegistrationDtoRequest {
    @NotNull
    private String email;
    @ValidPassword
    private String password;
    @NotNull
    private String name;

    private String address;

}
