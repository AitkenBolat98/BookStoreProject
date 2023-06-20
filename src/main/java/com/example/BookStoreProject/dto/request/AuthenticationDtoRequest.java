package com.example.BookStoreProject.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDtoRequest {

    private String email;

    private String password;
}
