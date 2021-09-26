package com.quan.week07_homework_09.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    /**
     * db1数据库配置
     */
    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * db2数据库配置
     */
    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据库配置
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(masterSource());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("master", masterSource());
        dsMap.put("slave", slaveSource());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
