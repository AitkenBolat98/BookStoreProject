package com.example.BookStoreProject.dto.response.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRegistrationDtoResponse {

    private String email;
    private String address;
    private String jwt;
}
