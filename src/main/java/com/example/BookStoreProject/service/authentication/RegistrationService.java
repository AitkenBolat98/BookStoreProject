package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;

public interface RegistrationService {

    UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request);


}
