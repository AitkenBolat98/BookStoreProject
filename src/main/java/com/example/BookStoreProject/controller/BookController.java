package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    @GetMapping("/search")
    public ResponseEntity<Set<Books>> searchBook(@RequestParam("query") String query){
        return ResponseEntity.ok(bookService.searchBooks(query));
    }
}
