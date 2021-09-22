package com.quan.week07_homework_09.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.week07_homework_09.entities.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    Integer insertBatchSomeColumn(List<Orders> orders);
}
