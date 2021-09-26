package com.quan.week07_homework_10.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.week07_homework_10.entities.Orders;
import com.quan.week07_homework_10.mappers.OrdersMapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> {
}
