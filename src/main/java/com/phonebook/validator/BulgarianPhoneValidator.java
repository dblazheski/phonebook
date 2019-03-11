package com.phonebook.validator;


import java.util.ArrayList;
import java.util.List;

public class BulgarianPhoneValidator implements Validator {

  private static final String BULGARIAN_COUNTRY_CODE = "359";

  private List<String> mobileOperatorCodes = new ArrayList<>();

  {
    mobileOperatorCodes.add("87");
    mobileOperatorCodes.add("88");
    mobileOperatorCodes.add("89");
  }

  @Override
  public boolean isValid(String number) {
    if (number.startsWith("0") || number.startsWith("00")) {
      if (number.length() == 10) {
        return isValidPhoneNumber(number, false);
      }
      if (number.length() == 14) {
        return isValidPhoneNumber(number, true) && isValidCountryCode(number);
      }
    }
    return false;
  }

  private boolean isValidCountryCode(String number) {
    return BULGARIAN_COUNTRY_CODE.equals(getCountryCode(number));
  }

  private boolean isValidPhoneNumber(String number, boolean longNumber) {
    String mobileOperatorCode = getMobileOperatorCode(number, longNumber);
    String digit = getDigit(number, longNumber);
    return containsOperatorCode(mobileOperatorCode) && isValidDigit(digit);
  }

  private String getCountryCode(String number) {
    return number.substring(2, 5);
  }

  private boolean containsOperatorCode(String mobileOperator) {
    for (String mobileOperatorCode : mobileOperatorCodes) {
      if (mobileOperatorCode.equals(mobileOperator)) {
        return true;
      }
    }
    return false;
  }

  private boolean isValidDigit(String digit) {
    Integer number;
    try {
      number = Integer.parseInt(digit);
    } catch (NumberFormatException e) {
      return false;
    }
    return number >= 2 && number <= 9;
  }

  private String getMobileOperatorCode(String number, Boolean longNumber) {
    if (longNumber) {
      return number.substring(5, 7);
    }
    return number.substring(1, 3);
  }

  private String getDigit(String number, Boolean longNumber) {
    if (longNumber) {
      return number.substring(7, 8);
    }
    return number.substring(3, 4);
  }
}
