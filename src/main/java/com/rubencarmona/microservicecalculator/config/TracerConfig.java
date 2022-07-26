package com.rubencarmona.microservicecalculator.config;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración del traceador.
 */
@Configuration
public class TracerConfig {

    @Bean
    TracerImpl tracer() {
        return new TracerImpl();
    }
}
