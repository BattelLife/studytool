package com.studydesign.studytoolweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = {"com.studydesign.studytoolbusiness","com.studydesign.studytoolbasic",
        "com.studydesign.studytoolportal","com.studydesign.studytoolweb"})
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class ,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.activiti.spring.boot.SecurityAutoConfiguration.class
})
@EnableSwagger2
public class StudytoolWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudytoolWebApplication.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.studydesign.studytoolportal.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(generateApiInfo());
    }

    private ApiInfo generateApiInfo() {
        return new ApiInfo("studytool", "studytool", "Version 1.0", "www.baddu.com", "cl", "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0");
    }
}
