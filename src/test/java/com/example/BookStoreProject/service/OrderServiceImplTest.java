package com.example.BookStoreProject.service;

import com.example.BookStoreProject.repository.OrdersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class OrderServiceImplTest {

    @Mock
    private OrdersRepository ordersRepository;
    @Mock
    private UserService userService;
    @Mock
    private OrderDetailService orderDetailService;
    private OrderServiceImpl undertest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        undertest = new OrderServiceImpl(ordersRepository,userService,orderDetailService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }


}