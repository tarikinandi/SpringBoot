package com.tarikinandi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.tarikinandi"})
@EnableJpaRepositories(basePackages = "com.tarikinandi")
@ComponentScan(basePackages = {"com.tarikinandi"})
@EnableScheduling
@SpringBootApplication
public class ExceptionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionManagementApplication.class, args);
    }

}
