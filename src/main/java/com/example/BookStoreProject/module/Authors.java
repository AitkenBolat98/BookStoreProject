package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Authors")
@Table(name = "authors")
@Getter
@Setter
public class Authors {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "description",
            columnDefinition = "TEXT")
    private String description;

    /*@OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.EAGER,
            mappedBy = "authors"
    )
    private List<Books_and_Authors> book = new ArrayList<>();*/
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();
}
