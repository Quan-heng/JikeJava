package com.example.homework02;

import com.example.homework02.entities.Orders;
import com.example.homework02.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Homework2ApplicationTests {
@Resource
private OrdersService ordersService;
    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        Orders orders = new Orders();
        orders.setStatus("test");
        orders.setUserId(121 );
        ordersService.save(orders);
    }

    @Test
    void get(){
       List<Orders> ordersList =  ordersService.list();
        for (Orders orders : ordersList) {
            System.out.println(orders.toString());
        }
    }
}
