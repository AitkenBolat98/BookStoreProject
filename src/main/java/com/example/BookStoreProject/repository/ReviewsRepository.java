package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM reviews r WHERE r.book_id = :bookId AND r.user_id = :userId",nativeQuery = true)
    void deleteReviewById(@Param("bookId") Long bookId,@Param("userId") Long userId);
    @Query(value = "SELECT * FROM reviews r WHERE r.book_id = :bookId AND r.user_id = :userId",nativeQuery = true)
    Reviews updateReview(@Param("bookId") Long bookId,@Param("userId") Long userId);
}
