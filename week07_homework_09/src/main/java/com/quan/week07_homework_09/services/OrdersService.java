package com.quan.week07_homework_09.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.quan.week07_homework_09.annotation.DataBase;
import com.quan.week07_homework_09.entities.Orders;
import com.quan.week07_homework_09.mappers.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> {

}
