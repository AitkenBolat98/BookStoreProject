
package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    Optional<Orders> findById(Long id);
    void delete(Orders order);
}

