package com.example.BookStoreProject.dto.response.liked;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LikedDtoResponse {

    private Long bookId;
}
