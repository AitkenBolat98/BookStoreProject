package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "Reviews")
@Table(name = "reviews")
@Data
public class Reviews {
    @EmbeddedId
    private ReviewsId id = new ReviewsId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id",
                foreignKey = @ForeignKey(name = "reviews_user_id_fk"))
    private Users user;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id",
                foreignKey = @ForeignKey(name = "reviews_book_id_fk"))
    private Books book;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @Column(name = "description",
            nullable = false,
            columnDefinition = "TEXT")
    private String description;



}
