package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.UserRegistrationDtoResponse;
import com.example.BookStoreProject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    public final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationDtoResponse> registration(@RequestBody UserRegistrationDtoRequest request){
        return ResponseEntity.ok(authenticationService.registration(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationDtoResponse> authenticate(@RequestBody AuthenticationDtoRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
