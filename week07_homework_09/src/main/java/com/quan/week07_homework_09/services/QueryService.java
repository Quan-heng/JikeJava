package com.quan.week07_homework_09.services;

import com.quan.week07_homework_09.annotation.DataBase;
import com.quan.week07_homework_09.entities.Orders;
import com.quan.week07_homework_09.mappers.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryService {
    @Resource
    private OrdersService ordersService;
    @DataBase("slave")
    public List<Orders> list(){
        return ordersService.list();
    }

    @DataBase("master")
    public boolean save(Orders orders){
        return ordersService.save(orders);
    }

    @DataBase("master")
    public boolean update(Orders orders){
        return ordersService.updateById(orders);
    }
}
