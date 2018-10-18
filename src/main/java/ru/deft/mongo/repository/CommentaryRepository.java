package ru.deft.mongo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.deft.mongo.domain.Commentary;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 7/27/2018
 */
public interface CommentaryRepository extends ReactiveCrudRepository<Commentary, String> {
  Flux<Commentary> findAllByBookId(String bookId);
}
