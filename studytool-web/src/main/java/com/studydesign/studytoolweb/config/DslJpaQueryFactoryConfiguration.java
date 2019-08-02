package com.studydesign.studytoolweb.config;

import com.querydsl.jpa.HQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class DslJpaQueryFactoryConfiguration {

    @PersistenceContext(unitName = "persisteUnit")
    private EntityManager entityManager;

    @Bean(name = "queryFactory")
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(new HQLTemplates(), entityManager);
    }

    @Bean(name = "sqlQueryFactory")
    public SQLQueryFactory sqlQueryFactory(@Qualifier("datasource") DataSource dataSource) {

        SQLTemplates templates = new MySQLTemplates();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        return new SQLQueryFactory(configuration, dataSource);
    }
}
