package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Liked;
import com.example.BookStoreProject.module.LikedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LikedRepository extends JpaRepository<Liked,Long> {
    Optional<Liked> findById(LikedId id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM liked l WHERE l.user_id = :userId and l.book_id = :bookId",nativeQuery = true)
    void deleteById(@Param("userId") Long userId, @Param("bookId") Long bookId);
}
