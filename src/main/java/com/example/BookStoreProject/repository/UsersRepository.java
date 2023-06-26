package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.LikedId;
import com.example.BookStoreProject.module.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);

    Optional<Users> findById(Long id);;
}
