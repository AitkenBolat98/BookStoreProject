package com.example.BookStoreProject.dto.response.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserPasswordResetDtoResponse {

    private String message;
}
