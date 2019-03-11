package com.phonebook;

import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueApplication {

  public static void main(String[] args) {
    NavigableSet<String> queue = new TreeSet<>();
    queue.add("1234");
    queue.add("13");
    queue.add("12345");
    System.out.println("Getting element via poll : " + queue.pollLast());
    for(String elem : queue) {
      System.out.println(elem);
    }
  }
}
