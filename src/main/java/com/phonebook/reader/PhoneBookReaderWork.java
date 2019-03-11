package com.phonebook.reader;

/**
 * Phone book reader worker that allows client to perform custom action when phone number is read.
 *
 * @author dejan.blazheski
 */
public interface PhoneBookReaderWork {

  /**
   * Execute custom action when phone number is read.
   *
   * @param row {@link PhoneBookRow} on which client will perform custom action.
   */
  void execute(PhoneBookRow row);
}
