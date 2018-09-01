package ru.deft.mongo.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deft.mongo.domain.Author;
import ru.deft.mongo.repository.AuthorRepository;

import java.util.UUID;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Service
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorRepository authorRepository;

  public void firstTest() {
	authorRepository.deleteAll();

	// save a couple of customers
	authorRepository.save(new Author("Alice", "Smith"));
	authorRepository.save(new Author("Bob", "Smith"));

	// fetch all customers
	System.out.println("Customers found with findAll():");
	System.out.println("-------------------------------");
	for (Author customer : authorRepository.findAll()) {
	  System.out.println(customer);
	}
	System.out.println();

	// fetch an individual customer
	System.out.println("Customer found with findByFirstName('Alice'):");
	System.out.println("--------------------------------");
	System.out.println(authorRepository.findByFirstName("Alice"));

	System.out.println("Customers found with findByLastName('Smith'):");
	System.out.println("--------------------------------");
	for (Author customer : authorRepository.findByLastName("Smith")) {
	  System.out.println(customer);
	}
  }

  public void printAuthors() {
	authorRepository.findAll().forEach(System.out::println);
  }

  public void printAuthorById(String id) {
	System.out.println(authorRepository.findById(id));
  }

  public void addAuthor(String firstName, String lastName) {
	System.out.println(authorRepository.save(new Author(firstName, lastName)));
  }
}