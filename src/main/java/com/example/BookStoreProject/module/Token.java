package com.example.BookStoreProject.module;

import com.example.BookStoreProject.constants.TokenType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "token")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Token {
    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(
            name = "token",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String token;
    @Column(
            name = "token_type",
            nullable = false,
            columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    @Column(
            name = "expired",
            nullable = false)
    private boolean expired;
    @Column(
            name = "revoked",
            nullable = false
    )
    private boolean revoked;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
