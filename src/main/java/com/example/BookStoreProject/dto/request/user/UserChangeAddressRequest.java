package com.example.BookStoreProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserChangeAddressRequest {
    @NotBlank(message = "the new Address field can not be blank")
    private String newAddress;
}
