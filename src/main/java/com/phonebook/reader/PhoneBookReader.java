package com.phonebook.reader;

/**
 * Phone book reader that reads information from data source.
 * Data source will be defined in the implementation of this interface.
 * While reading the phone numbers, every number will be returned to the
 * client to perform action of that phone number.
 *
 * @author dejan.blazheski
 */
public interface PhoneBookReader {

  /**
   * Perform reading from the data source.
   * Every phone number will be returned to the client with {@link PhoneBookReaderWork}
   *
   * @param work Implementation of the {@link PhoneBookReaderWork} which client defines his action to pefrorm
   *             on given phone number;
   */
  void read(PhoneBookReaderWork work);
}
