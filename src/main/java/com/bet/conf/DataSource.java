package com.bet.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pengweiyuan on 4/3/16.
 */
@Configuration
public class DataSource {
    @Value("${mysql.druidDataSource.url}")
    private String jdbcUrl;

    @Value("${mysql.druidDataSource.username}")
    private String jdbcUserName;

    @Value("${mysql.druidDataSource.password}")
    private String jdbcPassword;

    @Bean
    public javax.sql.DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }
}
