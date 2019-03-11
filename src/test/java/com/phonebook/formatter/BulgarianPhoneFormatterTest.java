package com.phonebook.formatter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BulgarianPhoneFormatterTest {

  private static final String SHORT_NUMBER = "0878123456";
  private static final String LONG_NUMBER = "00359878123456";
  private static final String INVALID_NUMBER = "8989855995";

  private final Map<String, String> testExpectations = new HashMap<>();

  {
    testExpectations.put(SHORT_NUMBER, "+359878123456");
    testExpectations.put(LONG_NUMBER, "+359878123456");
  }

  private BulgarianPhoneFormatter bulgarianPhoneFormatter;

  @BeforeEach
  public void init() {
    bulgarianPhoneFormatter = new BulgarianPhoneFormatter();
  }

  @Test
  @DisplayName("Formatter should format correctly short number")
  public void testformatShortNumber() {
    String formattedNumber = bulgarianPhoneFormatter.format(SHORT_NUMBER);
    assertEquals(testExpectations.get(SHORT_NUMBER), formattedNumber);
  }

  @Test
  @DisplayName("Formatter should format correctly long number")
  public void testformatLongNumber() {
    String formattedNumber = bulgarianPhoneFormatter.format(LONG_NUMBER);
    assertEquals(testExpectations.get(LONG_NUMBER), formattedNumber);
  }

  @Test
  @DisplayName("Formatter shouldn't format the number if doesn't start with 1 or 2 zeros")
  public void testNoFormatInvalidNumber() {
    String formattedNumber = bulgarianPhoneFormatter.format(INVALID_NUMBER);
    assertEquals(INVALID_NUMBER, formattedNumber);
  }

}