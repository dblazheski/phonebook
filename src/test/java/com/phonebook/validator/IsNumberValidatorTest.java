package com.phonebook.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsNumberValidatorTest {

  private IsNumberValidator isNumberValidator;

  @BeforeEach
  public void init() {
    this.isNumberValidator = new IsNumberValidator();
  }

  @Test
  @DisplayName("Validator should pass if string is number")
  public void testIsNumber() {
    String number = "123456";
    assertTrue(isNumberValidator.isValid(number));
  }

  @Test
  @DisplayName("Validator shouldn't pass if string is not number")
  public void testIsNotNumber() {
    String invalid = "123qweasd";
    assertFalse(isNumberValidator.isValid(invalid));
  }

  @Test
  @DisplayName("Validator shouldn't pass if string is null")
  public void testIsNull() {
    assertFalse(isNumberValidator.isValid(null));
  }
}