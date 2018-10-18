package ru.deft.mongo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import ru.deft.mongo.AjaxResponseBody;
import ru.deft.mongo.SearchCriteria;
import ru.deft.mongo.domain.Book;
import ru.deft.mongo.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@RestController
@RequestMapping("book")
@AllArgsConstructor
public class BookController {

  private final BookRepository bookRepository;

  @PostMapping("/search")
  public ResponseEntity<?> getSearchResultViaAjax(
		  @Valid @RequestBody SearchCriteria search, Errors errors) {

	AjaxResponseBody result = new AjaxResponseBody();

	//If error, just return a 400 bad request, along with the error message
	if (errors.hasErrors()) {

	  result.setMsg(errors.getAllErrors()
			  .stream().map(x -> x.getDefaultMessage())
			  .collect(Collectors.joining(",")));

	  return ResponseEntity.badRequest().body(result);

	}

	Flux<Book> users = bookRepository.findAllByName(search.getBookName());
	if (Objects.requireNonNull(users.collectList().block()).isEmpty()) {
	  result.setMsg("no book found!");
	} else {
	  result.setMsg("success");
	}
	result.setResult(users.collectList().block());
	return ResponseEntity.ok(result);

  }

}
