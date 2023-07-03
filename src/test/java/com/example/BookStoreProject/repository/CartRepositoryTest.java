package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Carts;
import com.example.BookStoreProject.module.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CartRepositoryTest {
    @Autowired
    private CartRepository underTest;
    @Autowired
    private UsersRepository usersRepository;
    @Test
    void deleteById() {

    }
}