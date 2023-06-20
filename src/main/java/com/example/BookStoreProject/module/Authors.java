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

    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "description",
            columnDefinition = "TEXT")
    private String description;

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "authors"
    )
    private List<Books_and_Authors> book = new ArrayList<>();

}
