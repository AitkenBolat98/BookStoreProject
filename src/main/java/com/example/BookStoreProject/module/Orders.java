package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity(name = "Orders")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @SequenceGenerator( name = "order_sequence",
                        sequenceName = "order_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "order_sequence")
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(name = "address",
            nullable = false,
            columnDefinition = "TEXT")
    private String address;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "order",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private OrderDetails orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "user_order_fk"
                )
    )
    private Users user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id",
            referencedColumnName = "id")
    private Books book;


}



