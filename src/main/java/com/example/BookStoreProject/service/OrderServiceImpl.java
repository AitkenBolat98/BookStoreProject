package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.orders.OrderCreationDtoRequest;
import com.example.BookStoreProject.dto.response.orders.OrderCreationDtoResponse;
import com.example.BookStoreProject.module.Orders;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    private final OrdersRepository ordersRepository;
    private final UserService userService;
    private final OrderDetailService orderDetailService;

    private Orders save(Orders order){
        return ordersRepository.save(order);
    }
    @Override
    @Transactional
    public OrderCreationDtoResponse createOrder(List<OrderCreationDtoRequest> requests, Principal principal) {
        Orders order = new Orders();
        try {
            LocalDateTime createdAt = LocalDateTime.now();
            String email = principal.getName();
            Users user = userService.getByUserEmail(email).orElseThrow();
            String address = requests.get(0).getAddress();
            order.setCreatedAt(createdAt);
            order.setUser(user);
            order.setAddress(address);
            orderDetailService.create(requests,order);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Order creation exception");
        }
        return OrderCreationDtoResponse.builder()
                .totalPrice(orderDetailService.totalPrice(requests))
                .build();

    }

    @Override
    public void deleteOrder(Long orderId, Principal principal) {
        Orders order = this.getById(orderId).orElseThrow();
        try {
            ordersRepository.delete(order);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Order delete exception");
        }
    }

    @Override
    public Optional<Orders> getById(Long id) {
        return ordersRepository.findById(id);
    }



}
