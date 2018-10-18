package ru.deft.mongo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@Data
public class SearchCriteria {
  @NotBlank(message = "name can't empty!")
  String bookName;

}
