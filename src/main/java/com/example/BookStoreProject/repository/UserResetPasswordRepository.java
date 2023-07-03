package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.ResetPassword;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserResetPasswordRepository extends CrudRepository<ResetPassword,Long> {
    @Query(value = "SELECT * FROM reset_password rw WHERE rw.token LIKE (%:token%")
    ResetPassword findByToken(String token);
}
