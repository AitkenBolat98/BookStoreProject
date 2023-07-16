package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books_and_authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksAndAuthors {
    @EmbeddedId
    private BooksAndAuthorsId id  = new BooksAndAuthorsId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(
            name = "book_id")
    private Books books;
    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(
            name = "author_id"
    )
    private Authors author;
}
