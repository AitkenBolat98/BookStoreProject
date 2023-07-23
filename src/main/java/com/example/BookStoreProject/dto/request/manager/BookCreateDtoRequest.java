package com.example.BookStoreProject.dto.request.manager;

import com.example.BookStoreProject.module.Authors;
import lombok.Getter;

import java.util.List;

@Getter
public class BookCreateDtoRequest {

    private String title;

    private String genre;

    private List<String> authorsList;

    private Double price;

    private Integer quantity;

    private String language;

    private String bookDescription;

    private String publisher;
}
