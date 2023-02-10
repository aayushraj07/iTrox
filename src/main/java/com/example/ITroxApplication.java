package com.example;

import com.example.commons.configurations.PropertiesListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ITroxApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ITroxApplication.class);
    app.addListeners(new PropertiesListener());
    app.run(args);
  }
}
