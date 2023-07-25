package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.user.UserChangeAddressRequest;
import com.example.BookStoreProject.dto.request.user.UserChangeEmailDtoRequest;
import com.example.BookStoreProject.dto.response.users.UserPreviousOrdersDtoResponse;
import com.example.BookStoreProject.module.Users;

import java.security.Principal;
import java.util.Optional;

public interface UserService {

    Optional<Users> getByUserEmail(String email);

    Optional<Users> getById(Long id);

    UserPreviousOrdersDtoResponse previousOrders(Principal principal);

    void deleteUser(Principal principal);
    Users save(Users user);
    void changeUserEmail(Principal principal, UserChangeEmailDtoRequest request);
    void changeUserAddress(Principal principal, UserChangeAddressRequest request);
}
