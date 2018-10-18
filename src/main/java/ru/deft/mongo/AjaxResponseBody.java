package ru.deft.mongo;

import lombok.Data;
import ru.deft.mongo.domain.Book;

import java.util.List;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@Data
public class AjaxResponseBody {
  String msg;
  List<Book> result;
}
