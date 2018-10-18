package ru.deft.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.10.2018
 */
@Data
@Document(collection = "users")
public class User {
  @Id
  private String id;
  private String name;
  private String password;
  private String enabled;
  private List<UserRoles> userRoles;

}
