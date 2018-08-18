package ru.deft.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.deft.mongo.service.AuthorService;
import ru.deft.mongo.service.BookService;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(Application.class);
	BookService bookService = context.getBean(BookService.class);
	bookService.save();
	bookService.getAll();
  }
}
