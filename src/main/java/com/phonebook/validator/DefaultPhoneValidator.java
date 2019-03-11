package com.phonebook.validator;

import java.util.ArrayList;
import java.util.List;

public class DefaultPhoneValidator implements PhoneValidator {

  private final List<Validator> validators = new ArrayList<>();

  public void registerValidator(Validator validator) {
    validators.add(validator);
  }

  public boolean isValid(String object) {
    for (Validator validator : validators) {
      if (!validator.isValid(object)) {
        return false;
      }
    }
    return true;
  }
}
