package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.OrderDetails;
import com.example.BookStoreProject.repository.OrderDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderDetailsServiceImplTest {
    @Mock
    private BookService bookService;

    @Mock
    private OrderDetailsRepository orderDetailsRepository;
    @Mock
    private List<OrderCreationDtoRequest> requests = new ArrayList<>();

    private OrderDetailsServiceImpl underTest;

    @InjectMocks
    private OrderDetails orderDetails = new OrderDetails();

    @BeforeEach
    void setUp() {
        underTest = new OrderDetailsServiceImpl(bookService, orderDetailsRepository);

    }
    @Test
    void save() {
        underTest.save(orderDetails);
        ArgumentCaptor<OrderDetails> captor = ArgumentCaptor.forClass(OrderDetails.class);
        verify(orderDetailsRepository).save(captor.capture());
        OrderDetails capturedOrderDetails = captor.getValue();
        assertThat(capturedOrderDetails).isEqualTo(orderDetails);
    }

    @Test
    void create() {


    }

    @Test
    void totalPrice() {
      /*  underTest.totalPrice(requests);
        Books books = bookService.getById(requests.get(0).getBookId()).orElseThrow();
        ArgumentCaptor<Books> booksArgumentCaptor = ArgumentCaptor.forClass(Books.class);
        verify(bookService).getById(booksArgumentCaptor.getValue().getId());
        Books capturedBook = booksArgumentCaptor.getValue();
        assertThat(capturedBook).isEqualTo(books);*/
    }
}