package com.example.BookStoreProject.dto.response;

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
