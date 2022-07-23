package com.rubencarmona.microservicecalculator.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracerConfig {

    @Bean
    TracerImpl tracer() {
        return new TracerImpl();
    }
}
