package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.OrderDtoRequest;
import com.example.BookStoreProject.module.Books;
import com.example.BookStoreProject.module.OrderDetails;
import com.example.BookStoreProject.module.Orders;
import com.example.BookStoreProject.repository.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderDetailsServiceImpl implements OrderDetailService{

    private final BookService bookService;

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetails save(OrderDetails orderDetails){
        return orderDetailsRepository.save(orderDetails);
    }
    @Override
    @Transactional
    public void create(List<OrderDtoRequest> requests, Orders orders) {
        for(OrderDtoRequest request:requests){
            OrderDetails orderDetails = new OrderDetails();
            try {
                Books books = bookService.getById(request.getBookId()).orElseThrow();
                orderDetails.setBook(books);
                orderDetails.setOrder(orders);
                orderDetails.setPrice(books.getPrice());
                orderDetails.setQuantity(request.getQuantity());
                this.save(orderDetails);
                bookService.updateBooks(books.getId(),request.getQuantity());
            }catch (Exception e){
                log.error(e.getMessage());
                throw new RuntimeException("Order Details Creation exception");
            }
        }
    }

    @Override
    public Double totalPrice(List<OrderDtoRequest> requests) {
        Double totalPrice = 0.0;
        for(OrderDtoRequest request:requests){
            Books books = bookService.getById(request.getBookId()).orElseThrow();
            totalPrice += books.getPrice();
        }
        return totalPrice;
    }


}
