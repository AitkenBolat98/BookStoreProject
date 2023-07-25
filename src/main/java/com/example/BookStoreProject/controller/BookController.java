package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/books")
@PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
public class BookController {

    private final BookService bookService;
    @GetMapping("/search")
    public ResponseEntity<Set<Books>> searchBook(@RequestParam(value = "query") String query){
        return ResponseEntity.ok(bookService.searchBooks(query));
    }
}
