package com.example.BookStoreProject.dto.request.liked;

import com.example.BookStoreProject.module.Books;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LikedDtoRequest {
    @NotBlank(message = "the email field can not be blank")
    private Long bookId;
}
