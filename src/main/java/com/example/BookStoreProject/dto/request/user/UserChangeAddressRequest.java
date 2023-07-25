package com.example.BookStoreProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserChangeAddressRequest {
    @NotBlank(message = "the new Address field can not be blank")
    private String newAddress;
}
