package ru.deft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.deft.mongo.domain.User;

/**
 * Created by Sergey Golitsyn (deft) on 18.10.2018
 */
public interface UserRepository extends MongoRepository<User, String> {
  User findByName(String username);
}
