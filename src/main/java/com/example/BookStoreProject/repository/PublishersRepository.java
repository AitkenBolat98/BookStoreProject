package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends JpaRepository<Publishers,Long> {
    @Query(value = "SELECT p FROM publishers p WHERE p.name = :publisherName",nativeQuery = true)
    Publishers findByName(@Param("publisherName") String publisherName);
}
