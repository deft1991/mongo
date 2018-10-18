package ru.deft.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.deft.mongo.service.BookService;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@RestController
public class SearchController {

  @Autowired
  BookService bookService;


}
