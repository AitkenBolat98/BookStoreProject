package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateDescriptionDtoRequest;
import com.example.BookStoreProject.dto.request.manager.author.AuthorUpdateNameDtoRequest;
import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.repository.AuthorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorServiceImpl implements AuthorService{
    private final AuthorsRepository authorsRepository;
    @Override
    public Authors getByName(String authorName) {
        return authorsRepository.findByName(authorName);
    }

    @Override
    public Optional<Authors> getById(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public List<Authors> assignAuthorsToBook(List<String> authorList){
        ArrayList<Authors> authorsArray = new ArrayList<>();
        for(String author:authorList){
            if(this.getByName(author) == null){
                Authors newAuthor = new Authors();
                newAuthor.setAuthorDescription(null);
                newAuthor.setName(author);
                newAuthor.setBooks(null);
                authorsArray.add(newAuthor);
            }else{
                authorsArray.add(this.getByName(author));
            }
        }
        return authorsArray;
    }

    @Override
    public void assignBooksToAuthors(Books book) {
        for(Authors author:book.getAuthors()){
            ArrayList<Books> newBooks = new ArrayList<>();
            newBooks.add(book);
            author.setBooks(newBooks);
            this.save(author);
        }
    }

    @Override
    public void updateAuthorName(Principal principal, AuthorUpdateNameDtoRequest request) {
        Authors authors = this.getById(request.getAuthorId()).orElseThrow();
        try {
            authors.setName(request.getNewName());
            this.save(authors);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update author name");
        }
    }

    @Override
    public void updateAuthorDescription(Principal principal, AuthorUpdateDescriptionDtoRequest request) {
        Authors authors = this.getById(request.getAuthorId()).orElseThrow();
        try {
            authors.setAuthorDescription(request.getNewDescription());
            this.save(authors);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("update author description");
        }
    }


    public Authors save(Authors author){
        return authorsRepository.save(author);
    }
}
