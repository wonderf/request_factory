package io.wonderf.factory.service.api;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("io.wonderf.factory.service.db.*")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
