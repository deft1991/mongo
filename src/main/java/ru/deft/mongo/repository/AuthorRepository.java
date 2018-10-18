package ru.deft.mongo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.deft.mongo.domain.Author;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface AuthorRepository extends ReactiveCrudRepository<Author, String> {
  Mono<Author> findByFirstName(String firstName);

  Flux<Author> findByLastName(String lastName);

  Flux<Author> findByLastNameAndFirstName(String lastName, String firstName);
}
