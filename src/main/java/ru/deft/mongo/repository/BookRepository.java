package ru.deft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.deft.mongo.domain.Book;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface BookRepository extends MongoRepository<Book, String> {
  List<Book> findAllByName(String name);
}
