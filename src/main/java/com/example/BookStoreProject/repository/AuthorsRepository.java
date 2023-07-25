package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors,Long> {
    @Query(value = "SELECT a FROM authors a WHERE a.name = :authorName",nativeQuery = true)
    Authors findByName(@Param("authorName") String authorName);

    Optional<Authors> findById(Long id);
}
