package ru.deft.mongo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Data
//@NoArgsConstructor
@Document(collection = "author")
public class Author {
  @Id
  private String id;
  private String firstName;
  private String lastName;

  public Author() {
  }

  public Author(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
  }
}
