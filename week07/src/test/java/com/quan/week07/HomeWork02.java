package com.quan.week07;

import com.quan.week07.entities.Orders;
import com.quan.week07.mappers.OrdersMapper;
import com.quan.week07.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class HomeWork02 {
    @Resource
    private OrdersMapper ordersMapper;

    ExecutorService executorService = Executors.newFixedThreadPool(18);

    /**
     * 1000000用100次分配插入用时20s。
     */
    @Test
    public void testInsert() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executorService.execute(() -> {
                ordersMapper.insertBatchSomeColumn(getInitData());
                System.out.println("index: " + index);
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) + "ms");
    }

    public List<Orders> getInitData() {
        List<Orders> orders = Collections.nCopies(10000, new Orders("test", 123));
        return orders;
    }
}
