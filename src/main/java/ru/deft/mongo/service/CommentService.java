package ru.deft.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.deft.mongo.domain.Commentary;
import ru.deft.mongo.repository.BookRepository;
import ru.deft.mongo.repository.CommentaryRepository;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 7/27/2018
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
  private final CommentaryRepository commentaryRepository;
  private final BookRepository bookRepository;

  public void addComment(String bookId, String comment) {
	Commentary commentary = new Commentary(comment);
	commentary.setBook(bookRepository.findById(bookId).orElseThrow());
	commentaryRepository.save(commentary);
  }

  public void readComment(String bookId) {
	commentaryRepository.findAllByBookId(bookId).forEach(System.out::println);
  }
}
