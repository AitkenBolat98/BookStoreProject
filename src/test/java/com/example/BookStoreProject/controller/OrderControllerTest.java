package com.example.BookStoreProject.controller;

import com.example.BookStoreProject.repository.OrdersRepository;
import com.example.BookStoreProject.service.OrderDetailService;
import com.example.BookStoreProject.service.OrderService;
import com.example.BookStoreProject.service.OrderServiceImpl;
import com.example.BookStoreProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;
    @MockBean
    UserService userService;
    @MockBean
    OrdersRepository repository;
    @MockBean
    OrderDetailService orderDetailService;



}