package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.BookCreateDtoRequest;
import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Publishers;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService{

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

    @Override
    public void createBooks(Principal principal, List<BookCreateDtoRequest> requests) {
        Users user = userService.getByUserEmail(principal.getName()).orElseThrow();
        for(BookCreateDtoRequest request:requests){
            Publishers publisher = publisherService.getByName(request.getPublisher());
            Books book = new Books();
            book.setTitle(request.getTitle());
            book.setQuantity(request.getQuantity());
            book.setBookDescription(request.getBookDescription());
            book.setGenre(request.getGenre());
            book.setLanguage(request.getLanguage());
            book.setAuthors(assignAuthorsToBook(request.getAuthorsList()));
            book.setPublisher(publisher);

        }
    }
    public List<Authors> assignAuthorsToBook(List<String> authorList){
        ArrayList<Authors> authorsArray = new ArrayList<>();
        for(String author:authorList){
            if(authorService.getByName(author) == null){
                Authors newAuthor = new Authors();
                newAuthor.setAuthorDescription(null);
                newAuthor.setName(author);
                newAuthor.setBooks(null);
                authorsArray.add(newAuthor);
            }else{
                authorsArray.add(authorService.getByName(author));
            }
        }
        return authorsArray;
    }
}
