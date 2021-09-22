package com.quan.week07.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.week07.entities.Orders;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    Integer insertBatchSomeColumn(List<Orders> orders);
}
