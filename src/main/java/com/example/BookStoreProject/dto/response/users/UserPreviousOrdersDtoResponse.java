package com.example.BookStoreProject.dto.response.users;

import com.example.BookStoreProject.module.Orders;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPreviousOrdersDtoResponse {
    private Orders orders;
}
