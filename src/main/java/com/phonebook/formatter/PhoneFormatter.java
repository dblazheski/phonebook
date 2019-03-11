package com.phonebook.formatter;

/**
 * Phone formatter that formats given number.
 * Implementation of this interface will define how the number will be formatted.
 *
 * @author dejan.blazheski
 */
public interface PhoneFormatter {

  /**
   * Formats the provided phone number.
   *
   * @param phoneNumber number that will be formatted.
   * @return formatted number.
   */
  String format(String phoneNumber);
}
