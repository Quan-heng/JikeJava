package com.quan.week07_homework_10;

import com.quan.week07_homework_10.entities.Orders;
import com.quan.week07_homework_10.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Week07Homework10ApplicationTests {
    @Resource
    private OrdersService ordersService;
    @Test
    void contextLoads() {
    }

    /**
     * 从slave读
     */
    @Test
    void readTest(){
        ordersService.list();
    }

    /**
     * 从master读
     */
    @Test
    void writeTest(){
        Orders orders=new Orders();
        orders.setName("order10");
        orders.setUserId(123l);
        ordersService.save(orders);
    }

}
