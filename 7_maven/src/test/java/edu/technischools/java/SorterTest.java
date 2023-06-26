package edu.technischools.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SorterTest {

  @Test
  void sortIntegersInAscendingOrder() {
    List<Integer> numbers = Arrays.asList(5, 3, 7, 1, 8, 2, 4, 6);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(expected, sorter.sort(numbers));
  }

  @Test
  void sortIntegersInDescendingOrder() {
    List<Integer> numbers = Arrays.asList(5, 3, 7, 1, 8, 2, 4, 6);
    List<Integer> expected = Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1);
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(expected, sorter.reverse(sorter.sort(numbers)));
  }

  @Test
  void sortEmptyList() {
    List<Integer> numbers = Collections.emptyList();
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(numbers, sorter.sort(numbers));
  }

  @Test
  void reverseEmptyList() {
    List<Integer> numbers = Collections.emptyList();
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(numbers, sorter.reverse(numbers));
  }

  @Test
  void sortSingletonList() {
    List<Integer> numbers = Collections.singletonList(42);
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(numbers, sorter.sort(numbers));
  }

  @Test
  void reverseSingletonList() {
    List<Integer> numbers = Collections.singletonList(42);
    Sorter<Integer> sorter = new Sorter<>();
    Assertions.assertEquals(numbers, sorter.reverse(numbers));
  }
}
