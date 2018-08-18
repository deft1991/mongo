package ru.deft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.deft.mongo.domain.Author;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
  Author findByFirstName(String firstName);
  List<Author> findByLastName(String lastName);
  List<Author> findByLastNameAndFirstName(String lastName, String firstName);
}
