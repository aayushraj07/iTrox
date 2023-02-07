package com.example;

import com.example.commons.configurations.PropertiesListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITroxApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ITroxApplication.class);
    app.addListeners(new PropertiesListener());
    app.run(args);
  }
}
