package com.example.BookStoreProject.controller.Manager;

import com.example.BookStoreProject.dto.request.manager.BookCreateDtoRequest;
import com.example.BookStoreProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/management/books/")
@RequiredArgsConstructor
public class ManagerBookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createBooks(
            List<BookCreateDtoRequest> requests,
            Principal principal){
        bookService.createBooks(principal,requests);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
