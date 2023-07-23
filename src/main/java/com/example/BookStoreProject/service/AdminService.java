package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.admin.AdminDeleteUserDtoRequest;

import java.security.Principal;

public interface AdminService {
    void deleteUser(Long userId);

}
