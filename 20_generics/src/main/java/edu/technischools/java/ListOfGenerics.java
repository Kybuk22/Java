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
import java.util.List;

/**
 * Typy generyczne w Javie, pozwalają na przekazanie "typu" do klasy,
 * Dzięki temu nasz kod będzie mniej podatny na błędy-zamiast przekazywać zawsze Object, możemy przekazać konkretny typ, unikając rzutowania.
 * 
 * Typu generyczne weryfikowane są tylko w trakcie kompilacji, skompilowany kod jest ich pozbawiony
 */
public class ListOfGenerics<T> {  // określając klasę, która będzie przyjmować typ generyczny, używamy < >
  // litera określająca typ, może być dowolnym identyfikatorem,
  // jednak przyjęto konwencję, jednoliterowych oznaczeń

  // przekazany typ generyczny, można wykorzystać dalej, przekazując w tym wypadku jako typ listy
  private List<T> list = new ArrayList<>(); // od Javy 7, nie trzeba podawać typu generycznego w konstruktorze,
  // kompilator sam go odgadnie, wystarczy <> (diamond operator)

  // ta metoda zwraca obiekt typu T
  public T get(int index) {
    return list.get(index);
  }

  // ta metoda przyjmuje obiekt typu T
  public void add(T d) {
    list.add(d);
  }

}
