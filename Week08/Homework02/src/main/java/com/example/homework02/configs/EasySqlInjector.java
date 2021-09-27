package com.example.homework02.configs;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

public class EasySqlInjector extends DefaultSqlInjector
{
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
      List<AbstractMethod> methods = super.getMethodList(mapperClass);
      methods.add(new InsertBatchSomeColumn());
      return methods;
    }
}
