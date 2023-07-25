package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.CartAddDtoRequest;
import com.example.BookStoreProject.dto.response.CartAddDtoResponse;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Carts;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final BookService bookService;

    private final UserService userService;

    public Carts save(Carts carts){
        return cartRepository.save(carts);
    }

    @Override
    public CartAddDtoResponse addToCart(CartAddDtoRequest request, Principal principal) {
        Carts carts = new Carts();
        try{
            Books book = bookService.getById(request.getBookId()).orElseThrow();
            String email = principal.getName();
            Users user = userService.getByUserEmail(email).orElseThrow();
            carts.setBook(book);
            carts.setUser(user);
            carts.setCreatedAt(LocalDateTime.now());
            this.save(carts);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("add to cart");
        }
        return CartAddDtoResponse
                .builder()
                .bookId(carts.getBook().getId())
                .build();
    }

    @Override
    public void deleteFromCart(Long bookId, Principal principal) {
        try{
            Users user = userService.getByUserEmail(principal.getName()).orElseThrow();
            Books book = bookService.getById(bookId).orElseThrow();
            cartRepository.deleteById(user.getId(),book.getId());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("cart book delete exception");
        }

    }
}
