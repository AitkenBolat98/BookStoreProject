package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {
}
