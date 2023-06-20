package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends JpaRepository<Publishers,Long> {
}
