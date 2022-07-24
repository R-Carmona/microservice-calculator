package com.rubencarmona.microservicecalculator.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SpringFoxSwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rubencarmona.microservicecalculator.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
    @Bean
    public ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("API de ejemplo de una calculadora")
                .description("API de ejemplo de una calculadora - Pruebas Técnicas - Desarrollada con SpringBoot.")
                .version("0.1.0").contact(new Contact("Rubén Carmona García","https://www.linkedin.com/in/rubencarmona/","carmonagarcia@gmail.com")).build();
    }
}