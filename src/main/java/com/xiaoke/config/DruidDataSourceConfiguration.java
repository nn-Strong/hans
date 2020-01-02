package com.xiaoke.config;


import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * dataSource 数据源配置
 */
@Configuration
@Data
public class DruidDataSourceConfiguration {

    @Value("${spring.datasource.druid.filters}")
    private String filters;
    @Value("${spring.datasource.druid.exception-sorter}")
    private String exceptionSorter;

    /**
     * @see org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.Tomcat
     * 仿写的你可以去了解
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        try {
            System.out.println(filters);
            dataSource.setFilters(filters);
            dataSource.setExceptionSorter(exceptionSorter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
