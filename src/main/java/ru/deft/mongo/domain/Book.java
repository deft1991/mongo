package ru.deft.mongo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Data
@Document(collection = "book")
public class Book {
  @Id
  private String id;
  private String name;
  private String description;
  private List<Author> authors;
  private List<Genre> genres;
  private List<Commentary> commentaries;

  public Book() {
  }

  public Book(String name) {
	this.name = name;
  }
}
