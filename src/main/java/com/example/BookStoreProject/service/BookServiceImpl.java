package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService{

    private final BooksRepository booksRepository;
    @Override
    public Optional<Books> getById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Set<Books> searchBooks(String query) {
        List<Books> booksTitle = booksRepository.searchBookByTitle(query);
        List<Books> booksGenre = booksRepository.searchBookByGenre(query);
        List<Books> booksAuthor = booksRepository.searchByAuthor(query);
        Set<Books> books = Stream.of(booksTitle,booksGenre,booksAuthor).flatMap(Collection::stream).collect(Collectors.toSet());
        return books;
    }

    public Books save(Books book){
        return booksRepository.save(book);
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
}
