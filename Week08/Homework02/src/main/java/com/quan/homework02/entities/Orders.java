package com.quan.homework02.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("t_order")
public class Orders {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String status;
    private Integer userId;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

}
