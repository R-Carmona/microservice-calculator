package com.rubencarmona.microservicecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicroservicecalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecalculatorApplication.class, args);
    }

}
