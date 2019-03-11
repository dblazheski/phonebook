package com.phonebook.validator;

import com.phonebook.PhoneNumber;

import java.util.Comparator;

public class OutgoingCallComparator implements Comparator<PhoneNumber> {

  @Override
  public int compare(PhoneNumber o1, PhoneNumber o2) {
    return o1.getOutgoingCalls() - o2.getOutgoingCalls();
  }
}
