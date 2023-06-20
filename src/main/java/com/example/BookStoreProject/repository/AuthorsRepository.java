package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors,Long> {
}
