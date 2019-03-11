package com.phonebook;

import com.phonebook.validator.OutgoingCallComparator;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

  private final SortedMap<String, PhoneNumber> phoneBook = new TreeMap<>();

  private final NavigableSet<PhoneNumber> topOutgoingCallNumbers = new TreeSet<>(new OutgoingCallComparator());

  public void addNumber(PhoneNumber phoneNumber) {
    phoneBook.put(phoneNumber.getName(), phoneNumber);
    topOutgoingCallNumbers.add(phoneNumber);
    if (topOutgoingCallNumbers.size() > 5) {
      topOutgoingCallNumbers.pollLast();
    }
  }

  public void removeNumberByName(String name) {
    phoneBook.remove(name);
  }

  public PhoneNumber getNumberByName(String name) {
    return phoneBook.get(name);
  }

  public void printPhoneBook() {
    for (PhoneNumber phoneNumber : phoneBook.values()) {
      System.out.println(phoneNumber.toString());
    }
  }

  public void pringTopOutgoingCalls() {
    for (PhoneNumber phoneNumber : phoneBook.values()) {
      System.out.println(phoneNumber.toString());
    }
  }
}
