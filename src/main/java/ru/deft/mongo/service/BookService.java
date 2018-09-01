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

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final GenreRepository genreRepository;

  public void save() {
	Author author1 = new Author("serg", "goreliy");
	Author author2 = new Author("ivan", "ivanow");
	Author author3 = new Author("anna", "bebe");
	Genre genre = new Genre();
	genre.setName("horror");

	Book book = new Book();
	book.setName("first book");
	ArrayList<Author> authors = new ArrayList<>();
	authors.add(author1);
	authors.add(author2);
	authors.add(author3);
	book.setAuthors(List.of(author1, author2, author3));
	book.setAuthors(authors);
	book.setGenres(List.of(genre));
	bookRepository.save(book);
  }

  public void printBooks() {
	bookRepository.findAll().forEach(System.out::println);
  }

  public void printOne(String id) {
	System.out.println(bookRepository.findById(id).orElseThrow());
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
	book.setAuthors(List.of(authorRepository.findById(authorId).orElseThrow()));
	book.setGenres(List.of(genreRepository.findById(genreId).orElseThrow()));
	bookRepository.save(book);
  }

}
