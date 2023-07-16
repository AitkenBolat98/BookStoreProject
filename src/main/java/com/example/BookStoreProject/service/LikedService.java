package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.liked.LikedDtoRequest;
import com.example.BookStoreProject.dto.response.liked.LikedDtoResponse;
import com.example.BookStoreProject.module.Liked;
import com.example.BookStoreProject.module.LikedId;

import java.security.Principal;
import java.util.Optional;

public interface LikedService {

    void liked(LikedDtoRequest request, Principal principal);

    void deleteLikedBook(Principal principal,Long id);

    Optional<Liked> getById(LikedId id);
}
