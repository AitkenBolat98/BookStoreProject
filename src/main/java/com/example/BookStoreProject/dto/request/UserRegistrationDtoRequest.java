package com.example.BookStoreProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRegistrationDtoRequest {

    private String email;

    private String password;

    private String address;

}
