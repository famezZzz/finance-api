package ru.top.financeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling; // 1. Импортируйте аннотацию

@SpringBootApplication
@EnableScheduling
public class FinanceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApiApplication.class, args);
    }
}
