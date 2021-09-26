package com.quan.homework02;

import com.quan.homework02.entities.Orders;
import com.quan.homework02.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Homework02ApplicationTests {
    @Resource
    private OrdersService ordersService;

    @Test
    void contextLoads() {
    }

    @Test
    void selectTest(){
        ordersService.list();
    }

    @Test
    void saveTest(){
        Orders orders= new Orders();
        orders.setUserId(2);
        orders.setStatus("test");
        ordersService.save(orders);
    }
}
