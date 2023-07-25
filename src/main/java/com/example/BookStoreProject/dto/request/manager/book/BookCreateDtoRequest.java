package com.example.BookStoreProject.dto.request.manager.book;

import com.example.BookStoreProject.module.Authors;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class BookCreateDtoRequest {
    @NotBlank(message = "the title field can not be blank")
    private String title;
    @NotBlank(message = "the genre field can not be blank")
    private String genre;
    @NotBlank(message = "the author list field can not be blank")
    private List<String> authorsList;
    @NotBlank(message = "the price field can not be blank")
    private Double price;
    @NotBlank(message = "the quantity field can not be blank")
    private Integer quantity;
    @NotBlank(message = "the language field can not be blank")
    private String language;
    @NotBlank(message = "the book description field can not be blank")
    private String bookDescription;
    @NotBlank(message = "the publisher field can not be blank")
    private String publisher;
}
