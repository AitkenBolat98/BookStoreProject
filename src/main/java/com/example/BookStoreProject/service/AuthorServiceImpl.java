package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.repository.AuthorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
