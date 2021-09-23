package com.quan.week07_homework_09;

import com.quan.week07_homework_09.entities.Orders;
import com.quan.week07_homework_09.services.OrdersService;
import com.quan.week07_homework_09.services.QueryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Week07Homework09ApplicationTests {
    @Resource
    private QueryService queryService;
    @Test
    void contextLoads() {
    }

    @Test
    void insertInMasterReadFromSlave(){
        Orders orders = new Orders();
        orders.setName("test");
        queryService.save(orders);
        Orders slaveOrders = queryService.list().get(0);
        Assertions.assertEquals("test",slaveOrders.getName());
    }

}
