package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Liked")
@Table(name = "liked")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Liked {
    @EmbeddedId
    private LikedId id = new LikedId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id",
                foreignKey = @ForeignKey(name = "liked_user_id_fk"))
    private Users user;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id",
                foreignKey = @ForeignKey(name = "liked_book_id_fk"))
    private Books book;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;
}
