package ru.deft.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 7/27/2018
 */
@Data
@AllArgsConstructor
@Document(collection = "comment")
public class Commentary {

  @Id
  private String id;

  @NotNull
  private String message;

  @NotNull
  private Book book;

  public Commentary() {
  }

  public Commentary(@NotNull String message) {
	this.message = message;
  }

  @Override
  public String toString() {
	return "Commentary{ " +
			"message='" + message + '\'' +
			'}';
  }
}
