package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.admin.AdminDeleteUserDtoRequest;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Service
@RequiredArgsConstructor
@Log4j2
public class AdminServiceImpl implements AdminService{
    private final UsersRepository usersRepository;
    private final UserService userService;
    @Override
    public void deleteUser(Long userId) {
        Users user = userService.getById(userId).orElseThrow();
        try {
            usersRepository.delete(user);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
