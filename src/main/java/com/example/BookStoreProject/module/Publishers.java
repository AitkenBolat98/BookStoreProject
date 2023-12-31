package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publishers")
@Table(name = "publishers")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publishers {

    @Id
    @SequenceGenerator( name = "publisher_sequence",
                        sequenceName = "publisher_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "publisher_sequence")
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "description",
            columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "publisher"
                /*fetch = FetchType.EAGER,
                orphanRemoval = true*/)
    private List<Books> publisherBooks = new ArrayList<>();

}
