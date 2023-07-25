package com.example.BookStoreProject.dto.request.liked;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LikedDtoRequest {
    @NotBlank(message = "the email field can not be blank")
    private Long bookId;
}
