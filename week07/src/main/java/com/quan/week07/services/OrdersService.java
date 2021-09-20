package com.quan.week07.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.week07.entities.Orders;
import com.quan.week07.mappers.OrdersMapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> {
}
