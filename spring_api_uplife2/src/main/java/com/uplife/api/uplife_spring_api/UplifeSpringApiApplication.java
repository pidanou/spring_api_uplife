package com.uplife.api.uplife_spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.uplife.api.controller","com.uplife.api.service"})
@EntityScan(basePackages = "com.uplife.api.model")
@EnableJpaRepositories(basePackages = "com.uplife.api.repository")
public class UplifeSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UplifeSpringApiApplication.class, args);
    }

}
