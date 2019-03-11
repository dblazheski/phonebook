package com.phonebook.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BulgarianPhoneValidatorTest {

  private BulgarianPhoneValidator bulgarianPhoneValidator;

  @BeforeEach
  public void init() {
    this.bulgarianPhoneValidator = new BulgarianPhoneValidator();
  }

  @ParameterizedTest
  @DisplayName("Validator should pass if number is in correct format")
  @ValueSource(strings = {"0872123456", "00359872123456"})
  public void testValidNumber(String number) {
    assertTrue(bulgarianPhoneValidator.isValid(number));
  }

  @ParameterizedTest
  @DisplayName("Validator shouldn't pass if number doesn't have operator code")
  @ValueSource(strings = {"0992123456", "00359812123456", "0112123456", "00359842123456"})
  public void testInvalidOperatorCode(String number) {
    assertFalse(bulgarianPhoneValidator.isValid(number));
  }

  @ParameterizedTest
  @DisplayName("Validator shouldn't pass if number doesn't have right digit")
  @ValueSource(strings = {"0871123456", "00359870123456", "087z123456", "0035987z123456"})
  public void testInvalidDigit(String number) {
    assertFalse(bulgarianPhoneValidator.isValid(number));
  }

  @ParameterizedTest
  @DisplayName("Validator shouldn't pass if number length is not right")
  @ValueSource(strings = {"08721234561", "003598721234567", "0872123456112", "00359872123456548"})
  public void testInvalidPhoneNumber(String number) {
    assertFalse(bulgarianPhoneValidator.isValid(number));
  }

  @ParameterizedTest
  @DisplayName("Validator shouldn't pass if number doesn't starts with one or two zeros")
  @ValueSource(strings = {"8721234561", "3598721234567", "872123456112", "359872123456548"})
  public void testPhoneNumberNotStartsWithZero(String number) {
    assertFalse(bulgarianPhoneValidator.isValid(number));
  }

  @ParameterizedTest
  @DisplayName("Validator shouldn't pass if long number doesn't contain Bulgarian country code")
  @ValueSource(strings = {"00389872123456", "00388872123456", "00381872123456", "00384872123456"})
  public void testPhoneNumberNotContainBulgarianCode(String number) {
    assertFalse(bulgarianPhoneValidator.isValid(number));
  }

}