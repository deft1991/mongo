package ru.deft.mongo.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Sergey Golitsyn (deft) on 01.09.2018
 */
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException{
  private final String message;

  public EntityNotFoundException() {
    message = "Запись не найдена";
  }
}
