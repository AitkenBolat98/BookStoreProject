package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Users;

import java.util.Optional;

public interface UserService {

    Optional<Users> getByUserEmail(String email);

    Optional<Users> getById(Long id);
}
