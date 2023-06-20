package com.example.BookStoreProject.dto.request;

import lombok.Data;

@Data
public class OrderDtoRequest {

    private Long bookId;

    private Integer quantity;

    private String address;
}
