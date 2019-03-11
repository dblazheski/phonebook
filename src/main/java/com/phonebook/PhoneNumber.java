package com.phonebook;

public class PhoneNumber {

  private String name;

  private String number;

  private Integer outgoingCalls;

  public PhoneNumber(String name, String number, Integer outgoingCalls) {
    this.name = name;
    this.number = number;
    this.outgoingCalls = outgoingCalls;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public Integer getOutgoingCalls() {
    return outgoingCalls;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ")
        .append(getName())
        .append(", Number: ")
        .append(getNumber()).append(", Count : ")
        .append(getOutgoingCalls());
    return sb.toString();
  }
}
