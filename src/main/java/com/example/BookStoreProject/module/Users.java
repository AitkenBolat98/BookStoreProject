package com.example.BookStoreProject.module;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity(name = "Users")
@Table( name = "users",
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique",columnNames = "email")
        })
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {

    @Id
    @SequenceGenerator( name = "user_sequence",
                        sequenceName ="user_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "user_sequence")
    @Column( name = "id",
             updatable = false)
    private Long id;

    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    @Column(name = "password",
            nullable = false,
            columnDefinition = "TEXT")
    private String password;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "address",
            nullable = false,
            columnDefinition = "TEXT")
    private String address;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user",
                cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Reviews> reviews;

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user"
    )
    private List<Carts> cart = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user"
    )
    private List<Liked> liked = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private List<Orders> orders;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user"
    )
    private ResetPassword resetPassword;
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user"
    )
    private List<Token> tokens = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
