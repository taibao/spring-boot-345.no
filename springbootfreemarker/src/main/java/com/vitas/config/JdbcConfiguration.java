package com.vitas.config;

/*
* 数据源的 jdbc 配置类
*/

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
//@PropertySource("classpath:/jdbc.properties") //加载指定的Properties配置文件
@EnableConfigurationProperties(JdbcProperties.class) //指定加载哪个配置信息属性类
public class JdbcConfiguration {

    @Autowired
    private JdbcProperties jdbcProperties;
    /*
     *实例化Druid
     */
    @Bean
    public DataSource getDataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setPassword(this.jdbcProperties.getPassword());
        source.setUsername(this.jdbcProperties.getUsername());
        source.setUrl(this.jdbcProperties.getUrl());
        source.setDriverClassName(this.jdbcProperties.getDriverClassName());
        return source;
    }
}
