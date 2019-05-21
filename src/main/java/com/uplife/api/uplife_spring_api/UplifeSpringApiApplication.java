package com.uplife.api.uplife_spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.uplife.api.controller")
@EntityScan("com.uplife.api.model")
@EnableJpaRepositories("com.uplife.api.repository")

public class UplifeSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UplifeSpringApiApplication.class, args);
    }

}
