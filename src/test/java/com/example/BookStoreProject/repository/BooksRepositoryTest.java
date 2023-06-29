package com.example.BookStoreProject.repository;

import com.example.BookStoreProject.module.Authors;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.Publishers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BooksRepositoryTest {
    @Autowired
    private BooksRepository underTest;

    @Autowired
    private PublishersRepository publishersRepository;
    @Test
    void searchBookByTitle() {
        //given
        Publishers publishers = new Publishers(1L,"ABC","");
        publishersRepository.save(publishers);
        Books book = new Books(1L,"War and Peace","World Classic",12000.0,20,"Russian","",publishers);
        underTest.save(book);

        //when
        List<Books> check  =  underTest.searchBookByTitle(book.getTitle());
        //then
        assertThat(check).isNotEmpty();
    }

    @Test
    void searchBookByGenre() {
        //given
        Publishers publishers = new Publishers(1L,"ABC","");
        publishersRepository.save(publishers);
        Books book = new Books(1L,"War and Peace","World Classic",12000.0,20,"Russian","",publishers);
        underTest.save(book);
        //when
        List<Books> check = underTest.searchBookByGenre(book.getGenre());
        //then
        assertThat(check).isNotEmpty();
    }
    @Test
    void searchByAuthor(){
        //given
        Publishers publishers = new Publishers(1L,"ABC","");
        publishersRepository.save(publishers);
        Books book = new Books(1L,"War and Peace","World Classic",12000.0,20,"Russian","",publishers);
        underTest.save(book);
        List<Books> booksByAuthor = new ArrayList<>();
        booksByAuthor.add(book);
        Authors authors = new Authors("Leo Tolstoy","",booksByAuthor);
        //when
        List<Books> check = underTest.searchByAuthor("Leo Tolstoy");
        //then
        assertThat(check).isNotEmpty();
    }
}