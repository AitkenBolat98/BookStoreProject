package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.liked.LikedDtoRequest;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Liked;
import com.example.BookStoreProject.module.LikedId;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.LikedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class LikedServiceImpl implements LikedService{

    private final UserService userService;

    private final BookService bookService;

    private final LikedRepository likedRepository;

    public Liked save(Liked liked){
        return likedRepository.save(liked);
    }
    @Override
    public void liked(LikedDtoRequest request, Principal principal) {
        Liked liked = new Liked();
        try {
            String email = principal.getName();
            Users user = userService.getByUserEmail(email).orElseThrow();
            Books books = bookService.getById(request.getBookId()).orElseThrow();
            LocalDateTime createdAt = LocalDateTime.now();
            liked.setBook(books);
            liked.setUser(user);
            liked.setCreatedAt(createdAt);
            this.save(liked);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Liked creation exception");
        }
    }

    @Override
    public void deleteLikedBook(Principal principal, Long id) {
        Users users = userService.getByUserEmail(principal.getName()).orElseThrow();
        Books books = bookService.getById(id).orElseThrow();
        likedRepository.deleteById(users.getId(),books.getId());
    }

    @Override
    public Optional<Liked> getById(LikedId id) {
        return likedRepository.findById(id);
    }
}
