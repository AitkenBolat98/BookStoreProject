package com.example.BookStoreProject.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartAddDtoResponse {
    private Long bookId;
}
