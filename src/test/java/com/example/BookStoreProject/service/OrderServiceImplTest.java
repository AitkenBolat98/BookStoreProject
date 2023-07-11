package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.module.Orders;
import com.example.BookStoreProject.repository.OrdersRepository;
import com.example.BookStoreProject.service.authentication.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrdersRepository ordersRepository;
    @Captor
    private ArgumentCaptor<ArrayList<OrderCreationDtoRequest>> captor;
    @Mock
    private UserService userService;
    @Mock
    private RegistrationService registrationService;
    @Mock
    private OrderDetailService orderDetailService;
    @Mock
    private Principal principal;
    private OrderServiceImpl undertest;
    @InjectMocks
    private Orders order = new Orders();
    @BeforeEach
    void setUp() {
        undertest = new OrderServiceImpl(ordersRepository,userService,orderDetailService);
    }

    @Test
    void deleteOrder(){
/*
        registrationService.registration()
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        undertest.deleteOrder(order.getId(),authentication);
        ArgumentCaptor<Orders> ordersArgumentCaptor = ArgumentCaptor.forClass(Orders.class);
        verify(ordersRepository).delete(ordersArgumentCaptor.capture());
        Orders capturedOrder = ordersArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(order);*/

    }
    @Test
    void canCreateOrder(){
        List<OrderCreationDtoRequest> requests = new ArrayList<>();
        order.setAddress("abc");
        order.setCreatedAt(LocalDateTime.now());
        undertest.createOrder(requests,principal);
        ArgumentCaptor<Orders> ordersArgumentCaptor = ArgumentCaptor.forClass(Orders.class);
        verify(orderDetailService).create(captor.capture(),ordersArgumentCaptor.capture());
        Orders capturedOrder = ordersArgumentCaptor.getValue();
        List<OrderCreationDtoRequest> capturedRequest = captor.getValue();
        assertThat(capturedOrder).isEqualTo(order);
        assertThat(capturedRequest).isEqualTo(capturedRequest);
    }


}