package com.example.BookStoreProject.dto.request.reviews;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsUpdateDtoRequest {
    @NotBlank(message = "the book ID field can not be blank")
    private Long bookId;
    @NotBlank(message = "the description field can not be blank")
    private String description;
}
