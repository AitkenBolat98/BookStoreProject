package com.example.BookStoreProject.service;

import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;


    @Override
    public Optional<Users> getByUserEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> getById(Long id) {
        return usersRepository.findById(id);
    }
}

