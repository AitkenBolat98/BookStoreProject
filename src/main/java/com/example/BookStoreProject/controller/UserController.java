package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.users.UserChangePasswordDtoResponse;
import com.example.BookStoreProject.dto.response.users.UserPreviousOrdersDtoResponse;
import com.example.BookStoreProject.service.UserService;
import com.example.BookStoreProject.service.authentication.UserResetPasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    public final UserService userService;
    public final UserResetPasswordService userResetPasswordService;
    @GetMapping("/history/orders")
    public ResponseEntity<UserPreviousOrdersDtoResponse> previousOrders(Principal principal){
        return ResponseEntity.ok(userService.previousOrders(principal));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUser(Principal principal){
        userService.deleteUser(principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/changePassword")
    public ResponseEntity<HttpStatus> changePassword(@RequestParam("token") String token, @Valid UserChangePasswordDtoRequest request){
        boolean result = userResetPasswordService.isValid(token);
        if(result == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
