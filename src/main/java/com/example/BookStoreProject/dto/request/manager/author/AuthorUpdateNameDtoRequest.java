package com.example.BookStoreProject.dto.request.manager.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthorUpdateNameDtoRequest {
    @NotBlank(message = "the author ID field can not be blank")
    private Long authorId;
    @NotBlank(message = "the newName field can not be blank")
    private String newName;
}
