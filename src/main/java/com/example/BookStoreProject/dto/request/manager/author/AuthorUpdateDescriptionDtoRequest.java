package com.example.BookStoreProject.dto.request.manager.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthorUpdateDescriptionDtoRequest {
    @NotBlank(message = "the author ID field can not be blank")
    private Long authorId;
    @NotBlank(message = "the newDescription field can not be blank")
    private String newDescription;
}
