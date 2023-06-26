package com.example.BookStoreProject.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

  /*  @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;
    @MockBean
    UserService userService;
    @MockBean
    OrdersRepository repository;
    @MockBean
    OrderDetailService orderDetailService;

    OrderServiceImpl orderServiceImpl = new OrderServiceImpl(userService,repository,orderDetailService);
    @Test
    void create() {
        Orders order = new Orders();
        order.setId(null);
        order.setOrderDetails(null);
        List<OrderCreationDtoRequest> dtoRequests = new ArrayList<OrderCreationDtoRequest>();
        given(orderService.create(any(dtoRequests))).willReturn(orderDetailService.totalPrice().ge)
    }*/
}