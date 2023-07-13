package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;
import com.example.BookStoreProject.service.authentication.AuthenticationService;
import com.example.BookStoreProject.service.authentication.UserResetPasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final UserResetPasswordService userResetPasswordService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationDtoResponse> registration(@RequestBody @Valid UserRegistrationDtoRequest request){
        return ResponseEntity.ok(authenticationService.registration(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationDtoResponse> authenticate(@RequestBody AuthenticationDtoRequest request){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/reset")
    public ResponseEntity<UserPasswordResetDtoResponse> resetPassword(@RequestBody UserPasswordResetDtoRequest request){
        return ResponseEntity.ok(userResetPasswordService.resetPassword(request));
    }
    @PostMapping("/changepassword")
    public ResponseEntity<HttpStatus> changePassword(@RequestParam(name = "token",defaultValue = "1") String token,
                                                     @RequestBody @Valid UserChangePasswordDtoRequest request){
        boolean result = userResetPasswordService.isValid(token);
        if(result == true){
            authenticationService.changePassword(request,token);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new RuntimeException("token is not valid");
        }
    }
}
