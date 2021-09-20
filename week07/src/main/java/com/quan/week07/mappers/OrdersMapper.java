package com.quan.week07.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.week07.entities.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collections;
import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    @Insert("INSERT INTO orders(name,user_id)"+
            "    VALUES "+
            "    <foreach collection=\"list\" item=\"item\" separator=\",\">" +
            "        (#{item.name},#{item.userid}) " +
            "    </foreach>")
    void insertBach(@Param("list") List<Orders> list);

    Integer insertBatchSomeColumn(List<Orders> orders);
}
