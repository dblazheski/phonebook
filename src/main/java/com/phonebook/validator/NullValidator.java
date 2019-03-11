package com.phonebook.validator;

public class NullValidator implements Validator {

  @Override
  public boolean isValid(String object) {
    return object != null;
  }
}
