package com.example.BookStoreProject.dto.request.manager.author;

import lombok.Getter;

@Getter
public class AuthorUpdateDescriptionDtoRequest {
    private Long authorId;

    private String newDescription;
}
