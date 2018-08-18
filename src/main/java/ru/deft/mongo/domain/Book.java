package ru.deft.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 18.08.2018
 */
@Data
@NoArgsConstructor
@Document(collection = "book")
public class Book {
  @Id
  private String id;
  private String name;
  private String description;
  List<Author> authors;
  List<Genre> genres;

}
