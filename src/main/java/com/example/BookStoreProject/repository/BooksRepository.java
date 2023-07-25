package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books,Long> {

    Optional<Books> findById(Long id);

    @Query(value = "SELECT b.id,b.title,b.price,b.book_description,b.genre,b.language,b.publisher_id,b.quantity" +
            " FROM books b WHERE b.title LIKE (%:query%)",nativeQuery = true)
    List<Books> searchBookByTitle(String query);

    @Query(value = "SELECT b.id,b.title,b.price,b.book_description,b.genre,b.language,b.publisher_id,b.quantity" +
            " FROM books b WHERE b.genre LIKE (%:query%)",nativeQuery = true)
    List<Books> searchBookByGenre(String query);
    @Query(value = "SELECT b.id,b.title,b.price,b.book_description,b.genre,b.language,b.publisher_id,b.quantity FROM books b inner join books_and_authors bas on b.id = bas.book_id " +
            "inner join authors a on bas.author_id = a.id WHERE a.name LIKE (%:query%)",nativeQuery = true)
    List<Books> searchByAuthor(String query);
}
