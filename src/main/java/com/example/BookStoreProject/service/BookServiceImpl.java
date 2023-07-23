package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.book.*;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService{
    @Autowired
    private final BooksRepository booksRepository;
    private final UserService userService;

    private final AuthorService authorService;
    private final PublisherService publisherService;
    @Override
    public Optional<Books> getById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Set<Books> searchBooks(String query) {
        List<Books> booksTitle = booksRepository.searchBookByTitle(query);
        List<Books> booksGenre = booksRepository.searchBookByGenre(query);
        List<Books> booksAuthor = booksRepository.searchByAuthor(query);
        Set<Books> books = Stream.of(booksTitle,booksGenre,booksAuthor)
                .flatMap(Collection::stream).collect(Collectors.toSet());
        return books;
    }

    public Books save(Books newBook){
        return booksRepository.save(newBook);
    }

    @Override
    public void updateBooks(Long id, Integer quantity) {
        Books book = this.getById(id).orElseThrow();
        try {
            book.setQuantity(book.getQuantity()-quantity);
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Book Update exception");
        }
    }
    @Override
    public void createBooks(Principal principal, List<BookCreateDtoRequest> requests) {
        Users user = userService.getByUserEmail(principal.getName()).orElseThrow();
        try {
            for(BookCreateDtoRequest request:requests){
                Books book = new Books();
                book.setTitle(request.getTitle());
                book.setQuantity(request.getQuantity());
                book.setBookDescription(request.getBookDescription());
                book.setGenre(request.getGenre());
                book.setLanguage(request.getLanguage());
                book.setAuthors(authorService.assignAuthorsToBook(request.getAuthorsList()));
                book.setPublisher(publisherService.assignPublisherToBook(request.getPublisher()));
                this.save(book);
                authorService.assignBooksToAuthors(book);
                publisherService.assignBooksToPublisher(book);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Book creation exception");
        }

    }


    @Override
    @Transactional
    public void updateBookQuantity(Principal principal, BookUpdateQuantityDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setQuantity(request.getNewQuantity());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book quantity exception");
        }
    }

    @Override
    @Transactional
    public void updateBookPrice(Principal principal, BookUpdatePriceDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setPrice(request.getNewPrice());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book price exception");
        }
    }

    @Override
    @Transactional
    public void updateBookDescription(Principal principal, BookUpdateDescriptionDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setBookDescription(request.getNewDescription());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book description exception");
        }
    }

    @Override
    @Transactional
    public void updateBookLanguage(Principal principal, BookUpdateLanguageDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setBookDescription(request.getNewLanguage());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book language exception");
        }
    }

    @Override
    @Transactional
    public void deleteBook(Principal principal, BookDeleteDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        booksRepository.delete(book);
    }

    @Override
    public void updateBookTitle(Principal principal, BookUpdateTitleDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setBookDescription(request.getNewTitle());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book Title exception");
        }
    }

    @Override
    public void updateBookGenre(Principal principal, BookUpdateGenreDtoRequest request) {
        Books book = this.getById(request.getBookId()).orElseThrow();
        try {
            book.setBookDescription(request.getNewGenre());
            this.save(book);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update book Genre exception");
        }
    }


}
