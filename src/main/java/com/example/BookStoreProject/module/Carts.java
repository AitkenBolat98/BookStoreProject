package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Carts")
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
    @EmbeddedId
    private CartId id = new CartId();

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "cart_user_id_fk"))
    private Users user;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(
            name = "book_id",
            foreignKey = @ForeignKey(name = "cart_book_id_fk"))
    private Books book;
}
