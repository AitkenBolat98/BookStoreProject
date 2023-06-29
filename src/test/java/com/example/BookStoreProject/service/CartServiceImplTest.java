package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Carts;
import com.example.BookStoreProject.repository.CartRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private BookService bookService;
    @Mock
    private  UserService userService;

    private CartServiceImpl underTest;

    @InjectMocks
    private Carts carts = new Carts();
    @BeforeEach
    void setUp() {
        underTest = new CartServiceImpl(cartRepository,bookService,userService);
    }

    @Test
    void save(Carts carts) {
        carts.setCreatedAt(LocalDateTime.now());
        cartRepository.save(carts);
        ArgumentCaptor<Carts> cartsArgumentCaptor = ArgumentCaptor.forClass(Carts.class);
        verify(cartRepository).save(cartsArgumentCaptor.capture());
        Carts capturedCart = cartsArgumentCaptor.getValue();
        assertThat(capturedCart).isEqualTo(carts);
    }

    @Test
    void deleteFromCart() {

    }
}