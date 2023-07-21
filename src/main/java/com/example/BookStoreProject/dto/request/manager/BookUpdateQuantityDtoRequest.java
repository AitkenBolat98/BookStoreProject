package com.example.BookStoreProject.dto.request.manager;

import lombok.Getter;

@Getter
public class BookUpdateQuantityDtoRequest {

    private Long bookId;
    private Integer newQuantity;
}
