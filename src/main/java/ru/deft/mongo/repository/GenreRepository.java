package ru.deft.mongo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.deft.mongo.domain.Genre;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
public interface GenreRepository extends ReactiveCrudRepository<Genre, String> {
}
