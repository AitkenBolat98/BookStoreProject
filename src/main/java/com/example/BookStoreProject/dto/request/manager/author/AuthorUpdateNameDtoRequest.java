package com.example.BookStoreProject.dto.request.manager.author;

import lombok.Getter;

@Getter
public class AuthorUpdateNameDtoRequest {

    private Long authorId;
    private String newName;
}
