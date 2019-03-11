package com.phonebook;

import com.phonebook.formatter.BulgarianPhoneFormatter;
import com.phonebook.formatter.PhoneFormatter;
import com.phonebook.reader.FilePhoneBookReader;
import com.phonebook.reader.PhoneBookReader;
import com.phonebook.validator.*;

import java.io.InputStream;

public class PhoneBookApplication {

  private static final String PHONE_NUMBER_FILE = "./phone-numbers.txt";

  public static void main(String[] args) {
    final InputStream fileStream = PhoneBookApplication.class.getClassLoader().getResourceAsStream(PHONE_NUMBER_FILE);
    final PhoneBookReader reader = new FilePhoneBookReader(fileStream);
    final PhoneValidator phoneValidator = initValidator();
    final PhoneFormatter phoneFormatter = new BulgarianPhoneFormatter();
    final PhoneBook phoneBook = new PhoneBook();

    reader.read(record -> {
      if (record.isValid() && phoneValidator.isValid(record.getPhoneNumber())) {
        final PhoneNumber phoneNumber = new PhoneNumber(record.getName(),
            phoneFormatter.format(record.getPhoneNumber()), record.getOutgoingCalls());
        phoneBook.addNumber(phoneNumber);
      }
    });

    phoneBook.printPhoneBook();
    phoneBook.pringTopOutgoingCalls();
  }

  private static PhoneValidator initValidator() {
    PhoneValidator phoneValidator = new DefaultPhoneValidator();
    phoneValidator.registerValidator(new NullValidator());
    phoneValidator.registerValidator(new IsNumberValidator());
    phoneValidator.registerValidator(new BulgarianPhoneValidator());
    return phoneValidator;
  }
}
