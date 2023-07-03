package com.example.BookStoreProject.dto.response.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationDtoResponse {

    private String email;
    private String jwt;
}
