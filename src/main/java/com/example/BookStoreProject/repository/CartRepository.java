package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Carts,Long> {
}
