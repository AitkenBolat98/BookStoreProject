package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Carts,Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM carts c WHERE c.user_id = :userId AND c.book_id = :bookId",nativeQuery = true)
    void deleteById(@Param("userId") Long userId,@Param("bookId") Long bookId);
}
