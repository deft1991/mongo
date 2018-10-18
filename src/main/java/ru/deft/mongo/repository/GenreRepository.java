package ru.deft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.deft.mongo.domain.Genre;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface GenreRepository extends MongoRepository<Genre, String> {
}
