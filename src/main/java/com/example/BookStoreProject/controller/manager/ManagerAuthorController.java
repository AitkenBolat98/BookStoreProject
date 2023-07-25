package com.example.BookStoreProject.controller.manager;

import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateDescriptionDtoRequest;
import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateNameDtoRequest;
import com.example.BookStoreProject.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/management/authors/")
@RequiredArgsConstructor
public class ManagerAuthorController {
    private final AuthorService authorService;

    @PutMapping("/update/name")
    ResponseEntity<HttpStatus> updateName(@RequestBody @Valid AuthorUpdateNameDtoRequest request, Principal principal){
        authorService.updateAuthorName(principal,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/description")
    ResponseEntity<HttpStatus> updateDescription(@RequestBody @Valid AuthorUpdateDescriptionDtoRequest request,Principal principal){
        authorService.updateAuthorDescription(principal,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
