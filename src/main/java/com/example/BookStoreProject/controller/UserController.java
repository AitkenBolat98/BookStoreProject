package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.response.users.UserPreviousOrdersDtoResponse;
import com.example.BookStoreProject.service.UserService;
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
    @GetMapping("/history/orders")
    public ResponseEntity<UserPreviousOrdersDtoResponse> previousOrders(Principal principal){
        return ResponseEntity.ok(userService.previousOrders(principal));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUser(Principal principal){
        userService.deleteUser(principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
