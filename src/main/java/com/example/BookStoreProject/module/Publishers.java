package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publishers")
@Table(name = "publishers")
@Getter
@Setter
@Data
@NoArgsConstructor
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

    @OneToMany(mappedBy = "publisher",
                fetch = FetchType.EAGER,
                orphanRemoval = true,
                cascade = {CascadeType.ALL})
    private List<Books> publisherBooks = new ArrayList<>();

    public Publishers(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
