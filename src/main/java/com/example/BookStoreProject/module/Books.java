package com.example.BookStoreProject.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "description",
            columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Liked> userLikedBook = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Carts> userAddedBookToCart = new ArrayList<>();


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Reviews> userReviewOfBook = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "book")
    private List<Books_and_Authors> authors = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publisher_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "publisher_book_fk"
            ))
    private Publishers publisher;
}
