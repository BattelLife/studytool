package com.studydesign.studytoolweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JpaConfiguration {

    @Autowired
    @Qualifier("datasource")
    private DataSource datasource;

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean("false"));
        jpaVendorAdapter.setShowSql(Boolean.parseBoolean("true"));
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(datasource);
        emf.setPackagesToScan("com.studydesign.studytoolbusiness","com.studydesign.studytoolbasic",
                "com.studydesign.studytoolportal","com.studydesign.studytoolweb");
        // 设置HibernateJpaVendorAdapter为JPA的JpaVendorAdapter。
        // 说明最终的jpa是由hibernate来完实现类的。
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPersistenceUnitName("persisteUnit");
        Properties properties = new Properties();
        //properties.setProperty("hibernate.default_schema", "base");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        emf.setJpaProperties(properties);
        return emf;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }



}