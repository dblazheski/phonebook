package com.phonebook.reader;


import java.io.*;

/**
 * Phone reader that reads information from given file as {@link InputStream}.
 *
 * @author dejan.blazheski
 */
public class FilePhoneBookReader implements PhoneBookReader {

  private static final String PHONE_BOOK_DELIMITER = ",";

  private final InputStream file;


  public FilePhoneBookReader(InputStream file) {
    if (file == null) {
      throw new IllegalArgumentException("Input stream cannot be null");
    }
    this.file = file;
  }

  @Override
  public void read(PhoneBookReaderWork work) {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split(PHONE_BOOK_DELIMITER);
        PhoneBookRow phoneBookRow = new PhoneBookRow(getRowTrimmed(splitLine, 0),
            getRowTrimmed(splitLine, 1),
            parseInt(getRowTrimmed(splitLine, 2)));
        work.execute(phoneBookRow);
      }
    } catch (Exception e) {
      throw new RuntimeException("Error while reading stream for phone book", e);
    }
  }

  private Integer parseInt(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  private String getRowTrimmed(String[] splitLine, int row) {
    if (splitLine == null || splitLine.length <= row) {
      return null;
    }
    return splitLine[row].trim();
  }
}
