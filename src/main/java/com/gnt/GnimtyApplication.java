package com.gnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GnimtyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GnimtyApplication.class, args);
    }

}
