package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.LikedDtoRequest;
import com.example.BookStoreProject.dto.response.LikedDtoResponse;
import com.example.BookStoreProject.service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/liked")
@RequiredArgsConstructor
public class LikedController {

    private final LikedService likedService;

    @PostMapping("/create")
    public ResponseEntity<LikedDtoResponse> like(@RequestBody LikedDtoRequest request, Principal principal){
        return ResponseEntity.ok(likedService.liked(request,principal));
    }
}
