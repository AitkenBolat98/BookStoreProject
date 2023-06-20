package com.example.BookStoreProject.module;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity(name = "BooksAndAuthors")
@Table(name = "books_and_authors")
public class Books_and_Authors {

    @EmbeddedId
    private Books_And_Authors_Id id;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(
            name = "author_id",
            foreignKey = @ForeignKey(name = "baa_author_id_fk"))
    private Authors authors;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(
            name = "book_id",
            foreignKey = @ForeignKey(name = "baa_book_id_fk"))
    private Books book;

}

