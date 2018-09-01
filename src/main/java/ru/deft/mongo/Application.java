package ru.deft.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
	SpringApplication.run(Application.class);
  }
}
