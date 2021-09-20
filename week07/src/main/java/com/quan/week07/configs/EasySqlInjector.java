package com.quan.week07.configs;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasySqlInjector extends DefaultSqlInjector
{
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
      List<AbstractMethod> methods = super.getMethodList(mapperClass);
      methods.add(new InsertBatchSomeColumn());
      return methods;
    }
}
