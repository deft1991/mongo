package ru.deft.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.deft.mongo.AjaxResponseBody;
import ru.deft.mongo.SearchCriteria;
import ru.deft.mongo.domain.Book;
import ru.deft.mongo.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@RestController
public class SearchController {

  @Autowired
  BookService bookService;


}
