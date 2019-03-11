package com.phonebook.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullValidatorTest {

  private NullValidator nullValidator;

  @BeforeEach
  public void init() {
    this.nullValidator = new NullValidator();
  }

  @Test
  @DisplayName("Validator shouldn't pass if value is null")
  public void testNullValue() {
    assertFalse(nullValidator.isValid(null));
  }

  @Test
  @DisplayName("Validator should pass if value is not null")
  public void testNotNullValue() {
    assertTrue(nullValidator.isValid("1234"));
  }
}