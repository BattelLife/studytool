package com.studydesign.studytoolweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@PropertySource("classpath:datasources/config.properties")
public class DataResourceConfiguration {

    @Resource
    private Environment env;
    @Primary
    @Bean(name = "datasource",destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("study_design.url"));
        datasource.setUsername(env.getProperty("study_design.username"));
        datasource.setPassword(env.getProperty("study_design.password"));
        datasource.setDriverClassName(env.getProperty("study_design.driverClassName"));

        //configuration
        datasource.setInitialSize(env.getProperty("study_design.initialSize",Integer.class));
        datasource.setMinIdle(env.getProperty("study_design.minIdle",Integer.class));
        datasource.setMaxActive(env.getProperty("study_design.maxActive",Integer.class));
        datasource.setMaxWait(env.getProperty("study_design.maxWait",Long.class));
        datasource.setTimeBetweenEvictionRunsMillis(env.getProperty("study_design.timeBetweenEvictionRunsMillis",Long.class));
        datasource.setMinEvictableIdleTimeMillis(env.getProperty("study_design.minEvictableIdleTimeMillis",Long.class));
        datasource.setValidationQuery(env.getProperty("study_design.validationQuery"));
        datasource.setTestWhileIdle(env.getProperty("study_design.testWhileIdle",Boolean.class));
        datasource.setTestOnBorrow(env.getProperty("study_design.testOnBorrow",Boolean.class));
        datasource.setTestOnReturn(env.getProperty("study_design.testOnReturn",Boolean.class));
        datasource.setPoolPreparedStatements(env.getProperty("study_design.poolPreparedStatements",Boolean.class));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(env.getProperty("study_design.maxPoolPreparedStatementPerConnectionSize",Integer.class));
        try {
            datasource.setFilters(env.getProperty("study_design.filters"));
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter : {0}"+e);
        }
        datasource.setConnectionProperties(env.getProperty("study_design.connectionProperties"));
        return datasource;
    }
}
