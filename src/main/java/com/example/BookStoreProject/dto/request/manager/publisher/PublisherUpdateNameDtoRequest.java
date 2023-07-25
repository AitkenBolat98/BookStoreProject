package com.example.BookStoreProject.dto.request.manager.publisher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PublisherUpdateNameDtoRequest {
    @NotBlank(message = "the publisher ID field can not be blank")
    private Long publisherId;
    @NotBlank(message = "the new name field can not be blank")
    private String newName;
}
