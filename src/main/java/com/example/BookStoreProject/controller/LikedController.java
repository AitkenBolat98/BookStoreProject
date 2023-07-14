package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.liked.LikedDtoRequest;
import com.example.BookStoreProject.dto.response.liked.LikedDtoResponse;
import com.example.BookStoreProject.service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/liked")
@RequiredArgsConstructor
public class LikedController {

    private final LikedService likedService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> likeBook(@RequestBody LikedDtoRequest request, Principal principal){
        likedService.liked(request,principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLikedBook(Principal principal,@PathVariable(name = "id") Long id){
        likedService.deleteLikedBook(principal,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
