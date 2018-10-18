package ru.deft.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.deft.mongo.domain.Book;
import ru.deft.mongo.repository.AuthorRepository;
import ru.deft.mongo.repository.BookRepository;
import ru.deft.mongo.repository.GenreRepository;

import java.util.Map;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@Controller
public class WelcomeController {

  @Value("${welcome.message:test}")
  private String message = "Hello World";

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private GenreRepository genreRepository;

  @GetMapping("/")
  public String welcome(Map<String, Object> model) {
    model.put("message", this.message);
    model.put("books", bookRepository.findAll());
    model.put("authors", authorRepository.findAll());
    model.put("genres", genreRepository.findAll());
    return "welcome";
  }

  @GetMapping("/editBook")
  public String editPage(@RequestParam("id") String id, Model model) {
    Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    model.addAttribute("book", book);
    return "editBook";
  }

  @PostMapping("/edit")
  public String notesEdit(@ModelAttribute Book book, Model model) {
    bookRepository.save(book);
    model.addAttribute("books", bookRepository.findAll());
    return "welcome";
  }
}
