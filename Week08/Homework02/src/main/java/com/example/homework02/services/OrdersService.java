package com.example.homework02.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.homework02.entities.Orders;
import com.example.homework02.mappers.OrdersMapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> {
}
