package com.example.BookStoreProject.dto.response.orders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreationDtoResponse {

    private Double totalPrice;
}
