package edu.technischools.java.three;

import java.util.Collections;
import java.util.List;

public class DescendingSortStrategy {

  public void sort(List<Integer> list) {
    Collections.sort(list, Collections.reverseOrder());
  }
}
