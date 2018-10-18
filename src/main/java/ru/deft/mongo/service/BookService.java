package ru.deft.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.deft.mongo.domain.Author;
import ru.deft.mongo.domain.Book;
import ru.deft.mongo.domain.Genre;
import ru.deft.mongo.repository.AuthorRepository;
import ru.deft.mongo.repository.BookRepository;
import ru.deft.mongo.repository.GenreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final GenreRepository genreRepository;

  public void printBooks() {
	bookRepository.findAll().toIterable().forEach(System.out::println);
  }

  public void printOne(String id) {
	System.out.println(bookRepository.findById(id));
  }

  public void addBook(String bookName) {
	this.addBook(bookName, null, null);
  }

  public void addBook(String bookName, String authorId) {
	this.addBook(bookName, authorId, null);
  }

  public void addBook(String bookName, String authorId, String genreId) {
	if (StringUtils.isEmpty(bookName)) {
	  throw new RuntimeException("Book name can`t be empty");
	}
	Book book = new Book(bookName);
	book.setAuthors(List.of(Objects.requireNonNull(authorRepository.findById(authorId).block())));
	book.setGenres(List.of(Objects.requireNonNull(genreRepository.findById(genreId).block())));
	bookRepository.save(book);
  }
}
