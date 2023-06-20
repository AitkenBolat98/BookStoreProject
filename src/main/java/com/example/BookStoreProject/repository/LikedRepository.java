package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Liked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedRepository extends JpaRepository<Liked,Long> {
}
