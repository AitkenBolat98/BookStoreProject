package com.example.BookStoreProject.dto.request.manager;

import lombok.Getter;

@Getter
public class BookUpdatePriceDtoRequest {
    private Long bookId;
    private Double newPrice;
}
