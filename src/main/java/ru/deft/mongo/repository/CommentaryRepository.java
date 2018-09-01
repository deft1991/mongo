package ru.deft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.deft.mongo.domain.Commentary;

import java.util.List;
import java.util.UUID;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 7/27/2018
 */
public interface CommentaryRepository extends MongoRepository<Commentary, String> {
  List<Commentary> findAllByBookId(String bookId);
}
