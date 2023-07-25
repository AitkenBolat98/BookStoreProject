package com.example.BookStoreProject.dto.request.manager.publisher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PublisherUpdateDescriptionDtoRequest {
    @NotBlank(message = "the publisher ID field can not be blank")
    private Long publisherId;
    @NotBlank(message = "the new description field can not be blank")
    private String newDescription;
}
