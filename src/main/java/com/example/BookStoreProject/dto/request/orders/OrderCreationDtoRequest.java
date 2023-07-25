package com.example.BookStoreProject.dto.request.orders;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderCreationDtoRequest {
    @NotBlank(message = "the book ID field can not be blank")
    private Long bookId;
    @NotBlank(message = "the quantity field can not be blank")
    private Integer quantity;
    @NotBlank(message = "the address field can not be blank")
    private String address;
}
