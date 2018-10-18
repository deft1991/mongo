package ru.deft.mongo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.deft.mongo.domain.Book;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface BookRepository extends ReactiveCrudRepository<Book, String> {
  Flux<Book> findAllByName(String name);

}
