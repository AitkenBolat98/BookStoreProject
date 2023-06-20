package com.example.BookStoreProject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDtoResponse {

    private Double totalPrice;
}
