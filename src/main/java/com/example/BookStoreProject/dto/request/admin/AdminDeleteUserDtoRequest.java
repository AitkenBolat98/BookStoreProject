package com.example.BookStoreProject.dto.request.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AdminDeleteUserDtoRequest {
    @NotBlank(message = "user ID can not be blank")
    private Long userId;

}
