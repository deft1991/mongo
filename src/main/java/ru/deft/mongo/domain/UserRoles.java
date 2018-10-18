package ru.deft.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sergey Golitsyn (deft) on 18.10.2018
 */
@Data
@Document(collection = "userRoles")
public class UserRoles {
  @Id
  private String id;
  private String role;
}
