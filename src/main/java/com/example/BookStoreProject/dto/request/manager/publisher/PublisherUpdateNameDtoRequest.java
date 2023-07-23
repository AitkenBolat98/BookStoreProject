package com.example.BookStoreProject.dto.request.manager.publisher;

import lombok.Getter;

@Getter
public class PublisherUpdateNameDtoRequest {
    private Long publisherId;
    private String newName;
}
