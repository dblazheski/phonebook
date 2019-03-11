package com.phonebook.reader;

public class PhoneBookRow {

  private String name;

  private String phoneNumber;

  private Integer outgoingCalls;

  public PhoneBookRow(String name, String phoneNumber, Integer outgoingCalls) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.outgoingCalls = outgoingCalls;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Integer getOutgoingCalls() {
    return outgoingCalls;
  }

  public boolean isValid() {
    return getName() != null && getPhoneNumber() != null && getOutgoingCalls() != null;
  }
}
