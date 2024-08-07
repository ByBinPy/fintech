package fintech.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"fintech.controllers","fintech.services.impl", "fintech.services", "fintech.data.impl.repos", "fintech.data.impl"})
public class ControllersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllersApplication.class, args);
    }

}
