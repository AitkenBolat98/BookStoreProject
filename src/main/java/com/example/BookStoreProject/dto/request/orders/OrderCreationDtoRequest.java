package com.example.BookStoreProject.dto.request.orders;

import lombok.Data;

@Data
public class OrderCreationDtoRequest {

    private Long bookId;

    private Integer quantity;

    private String address;
}
