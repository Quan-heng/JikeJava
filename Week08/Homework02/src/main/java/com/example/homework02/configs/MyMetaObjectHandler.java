package com.example.homework02.configs;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long timestamp = System.currentTimeMillis();
        this.setFieldValByName("createTime",timestamp,metaObject);
        this.setFieldValByName("updateTime",timestamp,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",System.currentTimeMillis(),metaObject);
    }
}
