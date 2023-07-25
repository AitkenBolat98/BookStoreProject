package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.dto.request.liked.LikedDtoRequest;
import com.example.BookStoreProject.service.LikedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/liked")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class LikedController {

    private final LikedService likedService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('user:create')")
    public ResponseEntity<HttpStatus> likeBook(@RequestBody @Valid LikedDtoRequest request, Principal principal){
        likedService.liked(request,principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public ResponseEntity<HttpStatus> deleteLikedBook(Principal principal,@PathVariable(name = "id") Long id){
        likedService.deleteLikedBook(principal,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
