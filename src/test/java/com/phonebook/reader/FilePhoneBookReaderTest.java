package com.phonebook.reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePhoneBookReaderTest {
  @Test
  @DisplayName("FilePhoneBookReader throws IllegalArgumentException on null constructor parameter")
  public void testThrowExceptionIfStreamNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      PhoneBookReader phoneBookReader = new FilePhoneBookReader(null);
    });
  }

  @Test
  @DisplayName("FilePhoneBookReader reads line properly by given delimiter")
  public void testReaderReadsLine() {
    String name = "FirstName";
    String number = "00359872123456";
    String line = name + "," + number;
    PhoneBookReader phoneBookReader = new FilePhoneBookReader(new ByteArrayInputStream(line.getBytes()));
    final List<PhoneBookRow> phoneBookRow = new ArrayList<>();
    phoneBookReader.read(phoneBookRow::add);
    assertTrue((phoneBookRow.size() == 1));
    PhoneBookRow bookRow = phoneBookRow.get(0);
    assertEquals(number, bookRow.getPhoneNumber());
    assertEquals(name, bookRow.getName());
  }

  @Test
  @DisplayName("FilePhoneBookReader trims record fields properly")
  public void testReaderReadsTrimmedLine() {
    String name = "FirstName   ";
    String number = "   00359872123456";
    String line = name + "," + number;
    PhoneBookReader phoneBookReader = new FilePhoneBookReader(new ByteArrayInputStream(line.getBytes()));
    final List<PhoneBookRow> phoneBookRow = new ArrayList<>();
    phoneBookReader.read(phoneBookRow::add);
    assertTrue((phoneBookRow.size() == 1));
    PhoneBookRow bookRow = phoneBookRow.get(0);
    assertEquals(number.trim(), bookRow.getPhoneNumber());
    assertEquals(name.trim(), bookRow.getName());
  }
}