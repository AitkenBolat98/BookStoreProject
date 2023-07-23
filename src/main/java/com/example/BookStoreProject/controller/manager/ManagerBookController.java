package com.example.BookStoreProject.controller.manager;

import com.example.BookStoreProject.dto.request.manager.book.*;
import com.example.BookStoreProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/management/books",
        consumes = "application/json")
@RequiredArgsConstructor
public class ManagerBookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createBooks(
            @RequestBody List<BookCreateDtoRequest> requests,
            Principal principal) {
        bookService.createBooks(principal, requests);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/quantity")
    public ResponseEntity<HttpStatus> updateBookQuantity(
            @RequestBody BookUpdateQuantityDtoRequest request,
            Principal principal) {
        bookService.updateBookQuantity(principal, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/price")
    public ResponseEntity<HttpStatus> updateBookPrice(
            @RequestBody BookUpdatePriceDtoRequest request,
            Principal principal) {
        bookService.updateBookPrice(principal, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/description")
    public ResponseEntity<HttpStatus> updateBookDescription(
            @RequestBody BookUpdateDescriptionDtoRequest request,
            Principal principal) {
        bookService.updateBookDescription(principal, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/language")
    public ResponseEntity<HttpStatus> updateBookDescription(
            @RequestBody BookUpdateLanguageDtoRequest request,
            Principal principal) {
        bookService.updateBookLanguage(principal, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/title")
    public ResponseEntity<HttpStatus> updateBookTitle(
            @RequestBody BookUpdateTitleDtoRequest request,
            Principal principal){
        bookService.updateBookTitle(principal,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/genre")
    public ResponseEntity<HttpStatus> updateBookGenre(
            @RequestBody BookUpdateGenreDtoRequest request,
            Principal principal){
        bookService.updateBookGenre(principal,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteBook(
            @RequestBody BookDeleteDtoRequest request,
            Principal principal) {
        bookService.deleteBook(principal, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}