package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity(name = "Books")
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    @SequenceGenerator( name = "book_sequence",
                        sequenceName = "book_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "book_sequence")
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(name = "title",
            nullable = false,
            columnDefinition = "TEXT")
    private String title;

    @Column(name = "genre",
            nullable = false,
            columnDefinition = "TEXT")
    private String genre;

    @Column(name = "price",
            nullable = false,
            columnDefinition = "FLOAT")
    private Double price;

    @Column(name = "quantity",
            nullable = false,
            columnDefinition = "BIGINT")
    private Integer quantity;

    @Column(name = "language",
            nullable = false,
            columnDefinition = "TEXT")
    private String language;

    @Column(name = "book_description",
            columnDefinition = "TEXT")
    private String bookDescription;

    @OneToMany(mappedBy = "book")
    private List<Liked> userLikedBook = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Carts> userAddedBookToCart = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Reviews> reviews;
    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "books")
    private List<BooksAndAuthors> booksAndAuthors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "publisher_book_fk"
            ))
    private Publishers publisher;
    @OneToMany(mappedBy = "book")
    private List<OrderDetails> orderDetails;
    @OneToMany(mappedBy = "book")
    private List<Orders> orders;
}
