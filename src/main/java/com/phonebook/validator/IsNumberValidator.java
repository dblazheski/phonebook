package com.phonebook.validator;

public class IsNumberValidator implements Validator {

  @Override
  public boolean isValid(String object) {
    return object != null && object.matches("[0-9]+");
  }
}
