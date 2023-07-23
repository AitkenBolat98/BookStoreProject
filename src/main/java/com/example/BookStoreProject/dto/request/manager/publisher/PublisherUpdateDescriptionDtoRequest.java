package com.example.BookStoreProject.dto.request.manager.publisher;

import lombok.Getter;

@Getter
public class PublisherUpdateDescriptionDtoRequest {
    private Long publisherId;
    private String newDescription;
}
