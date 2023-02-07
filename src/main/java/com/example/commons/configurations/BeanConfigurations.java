package com.example.commons.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
 @EnableJpaAuditing
public class BeanConfigurations implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/api/**")
        .allowedOrigins(
            "http://localhost",
            "http://localhost:3000",
            "http://localhost:8000",
            "http://localhost:8089",
            "http://localhost:5500",
            "http://65.2.21.231:8084")
        .allowedMethods("GET", "POST", "DELETE", "HEAD", "PUT", "FETCH", "OPTIONS");
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
