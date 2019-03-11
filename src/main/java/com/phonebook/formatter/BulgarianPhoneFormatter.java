package com.phonebook.formatter;

public class BulgarianPhoneFormatter implements PhoneFormatter {

  private static final String COUNTRY_PREFIX = "+359";

  @Override
  public String format(String phoneNumber) {
    if (phoneNumber.startsWith("00")) {
      return "+" + phoneNumber.substring(2);
    }
    if (phoneNumber.startsWith("0")) {
      return COUNTRY_PREFIX + phoneNumber.substring(1);
    }
    return phoneNumber;
  }
}
