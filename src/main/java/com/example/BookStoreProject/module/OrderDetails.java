package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "OrderDetails")
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetails {

    @Id
    @SequenceGenerator( name = "order_details_sequence",
                        sequenceName = "order_details_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "order_details_sequence")
    @Column(name = "id",
            updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,
              fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id",
                referencedColumnName = "id")
    private Orders order;

    @Column(name = "price",
            nullable = false,
            columnDefinition = "FLOAT")
    private Double price;

    @Column(name = "quantity",
            nullable = false,
            columnDefinition = "BIGINT")
    private Integer quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
                fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id",
                referencedColumnName = "id")
    private Books book;




}

