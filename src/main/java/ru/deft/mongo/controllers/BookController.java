package ru.deft.mongo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.deft.mongo.repository.BookRepository;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@Controller
@AllArgsConstructor
public class BookController {

  private final BookRepository bookRepository;


}
