package com.phonebook.validator;

/**
 * Validator that will check if given number is valid.
 *
 * @author dejan.blazheski
 */
public interface PhoneValidator {

  /**
   * Checks if given number passes the validation.
   *
   * @param number phone number that will be validated
   * @return true if given number is valid, otherwise false.
   */
  boolean isValid(String number);

  void registerValidator(Validator validator);
}
