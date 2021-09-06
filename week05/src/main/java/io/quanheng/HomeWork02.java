package io.quanheng;

import io.quanheng.entity.Device;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。
 */
public class HomeWork02 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Device device001 = (Device) context.getBean("device001");
        System.out.println(device001.toString());
    }


}
