package com.example.BookStoreProject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CartAddDtoRequest {
    @NotBlank(message = "the book ID field can not be blank")
    private Long bookId;

}
