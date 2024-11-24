package ru.rodionov.abitur;

import org.springframework.boot.SpringApplication;

public class TestAbiturApplication {

    public static void main(String[] args) {
        SpringApplication.from(AbiturApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
