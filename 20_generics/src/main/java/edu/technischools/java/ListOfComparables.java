/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Określając typy generyczne możemy określić, dokładnie jakiego typu oczekujemy, używając
 * extends, super w połączeniu z typami jakie nasz typ ma rozszerzać (extends) lub jakiego typu ma być super typem
 */
public class ListOfComparables<T extends Comparable<T>> { // oczekujemy typów, które implementują interfejs Comparable

  List<T> listOfComparables = new ArrayList<>();

  List<T> sort() {
    Collections.sort(listOfComparables);  // gdyby nasz typ generyczny nie implementował interfejsu Comparable, nie dałoby się posortować takiej listy

    return listOfComparables;
  }

  void add(T... elements) {
    this.listOfComparables.addAll(List.of(elements));
  }

}
