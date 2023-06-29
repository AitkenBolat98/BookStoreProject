package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Books")
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Books {
    public Books(Long id, String title, String genre, Double price, Integer quantity, String language, String bookDescription, Publishers publisher) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
        this.language = language;
        this.bookDescription = bookDescription;
        this.publisher = publisher;
    }

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

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Liked> userLikedBook = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Carts> userAddedBookToCart = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Reviews> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_and_authors"
                ,joinColumns = {
            @JoinColumn(name = "book_id")
    },inverseJoinColumns = {
            @JoinColumn(name = "author_id")
    })
    private List<Authors> authors;

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
