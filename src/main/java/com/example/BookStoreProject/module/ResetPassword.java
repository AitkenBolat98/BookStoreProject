package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reset_password")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPassword {
    private static final int EXPIRATION = 24*60;

    @Id
    @SequenceGenerator(
            name = "reset_password_sequence",
            sequenceName = "reset_password_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reset_password_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "token",
            nullable = false,
            columnDefinition = "TEXT"
        )
    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id")
    private Users user;

    @Column(
            name = "expiration_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime expirationDate;
}
