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
 * Możemy jeszcze bardziej doszczegółowić typ, używając & - nasz typ generyczny w tym wypadku musi rozszerzać klasę Number
 * i implementować Comparable
 */
public class ListOfComparableNumbers<T extends Number & Comparable<T>> { // oczekujemy typów, które implementują interfejs Comparable i rozszerzają klasę Number

  List<T> listOfComparables = new ArrayList<>();

  List<T> sort() {
    Collections.sort(listOfComparables);  // gdyby nasz typ generyczny nie implementował interfejsu Comparable, nie dałoby się posortować takiej listy

    return listOfComparables;
  }

  void add(T... elements) {
    this.listOfComparables.addAll(List.of(elements));
  }

  // Java pozwala także używać '?' (wildcard), oznacza to dowolny typ - taki zapis używany jest najczęściej typ parametru
  // zmiennej itp. gdy konkretny typ nie jest nam potrzebny.
  // W tym wypdku oczekujemy listy z elementami, które, rozszerzają klasę Number


  public double sum(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
      sum += n.doubleValue();
    }
    return sum;
  }
}
