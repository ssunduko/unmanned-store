package com.unmannedstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI unmannedStoreOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Unmanned Store API")
                        .description("API for managing an autonomous retail store")
                        .version("0.1.0")
                        .contact(new Contact()
                                .name("Unmanned Store Team")
                                .email("support@unmannedstore.com")));
    }
} 