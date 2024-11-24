package ru.ksanxxx.abitur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"ru.rodionov.abitur.repository"})
@EntityScan(basePackages = {"ru.rodionov.abitur.model"})
public class AbiturApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbiturApplication.class, args);
    }

}
