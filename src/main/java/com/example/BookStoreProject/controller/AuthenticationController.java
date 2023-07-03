package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;
import com.example.BookStoreProject.service.authentication.AuthenticationService;
import com.example.BookStoreProject.service.authentication.UserResetPasswordService;
import jakarta.validation.Valid;
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
    public final UserResetPasswordService userResetPasswordService;
    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationDtoResponse> registration(@RequestBody @Valid UserRegistrationDtoRequest request){
        return ResponseEntity.ok(authenticationService.registration(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationDtoResponse> authenticate(@RequestBody AuthenticationDtoRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/reset")
    public ResponseEntity<UserPasswordResetDtoResponse> resetPassword(@RequestBody UserPasswordResetDtoRequest request){
        return ResponseEntity.ok(userResetPasswordService.resetPassword(request));
    }
}
