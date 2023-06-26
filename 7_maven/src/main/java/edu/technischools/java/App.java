/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

import java.util.*;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer numberOfNumbers = null;
    List<Integer> numbers = new ArrayList<>();

    System.out.println("How many number do you want to enter");
    while ((numberOfNumbers = readNumber(scanner)) == null) {
    }

    for (int i = 0; i < numberOfNumbers; i++) {
      System.out.println("Enter " + (i + 1) + " number");
      Integer number;
      while ((number = readNumber(scanner)) == null) {
      }
      
      numbers.add(number);
    }

    Sorter<Integer> sorter = new Sorter<>();

    System.out.println(sorter.sort(numbers));
    System.out.println(sorter.reverse(sorter.sort(numbers)));
  }

  private static Integer readNumber(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException ime) {
      System.out.println("Given number is not an integer, try again");
      scanner.next();
      return null;
    }
  }
}
