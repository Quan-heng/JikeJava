package com.quan.week07.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Orders {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Long userId;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    public Orders(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }
}
