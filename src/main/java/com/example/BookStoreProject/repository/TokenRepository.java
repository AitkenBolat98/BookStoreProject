package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    @Query(value = "SELECT t.id,t.token,t.token_type,t.expired,t.revoked,t.user_id FROM token t INNER JOIN users u on t.user_id = u.id WHERE u.id = :userId" +
            " and (t.expired = false or t.revoked = false)",nativeQuery = true)
    List<Token> findAllValidTokensByUser(@Param("userId") Long userId);

    Optional<Token> findByToken(String token);
}
