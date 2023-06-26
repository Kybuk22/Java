/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

import java.math.BigDecimal;
import java.util.List;

public class Lists {

  public static void main(String[] args) {

    // definiując zmienną używjącą typu generycznego podajemy ją w <>
    ListOfGenerics<Integer> genericListOfIntegers = new ListOfGenerics<>();

    ListOfGenerics<Double> genericListOfDoubles = new ListOfGenerics<>();

    genericListOfDoubles.add(0.5);

    genericListOfIntegers.add(1);
    genericListOfIntegers.get(0);


    // możemy przekazać również i Object - wówczas możemy dodać dowolny obiekt

    ListOfGenerics<Object> generics = new ListOfGenerics<>();

    generics.add(1); // 1 -> Integer jest typu Object - więc możemy dodać bez błędów
    generics.add("abc"); // "abc" -> String jest typu obiekt, analogicznie jak wyżej możemy dodać do listy obiektów
    generics.add(genericListOfDoubles);

//    ((ListOfGenerics<Double>) generics.get(1)).get(0);

    // Możemy również stworzyć klasą bez określania typu generycznego-wówczas mamy Object ...
    ListOfGenerics ungenericList = new ListOfGenerics();

    //... ale w takim wypadku, dostaniemy ostrzeżenie, że nie używamy typów generycznych
    ungenericList.add("cde");
    ungenericList.add(0.05);


    // ponieważ klasa Car implementuje Comparable - możemy jej użyć jako typu generycznego
    ListOfComparables<Car> comparableList = new ListOfComparables<>();

    Car slowCar = new Car(1);
    Car fastCar = new Car(7);

    System.out.println(slowCar.compareTo(fastCar) < 0 ? "slower" : "faster");


    fastCar.fasterThan(new BigDecimal(5.5));
    fastCar.fasterThan(2.0);
    fastCar.fasterThan(2);


    comparableList.add(new Car(1), new Car(3), new Car(9), new Car(7), new Car(2));

    System.out.println(comparableList.sort());


    //Tutaj ograniczamy się do klas, które rozszerzają Number, więc np. Integer, Double itp.
    ListOfComparableNumbers<Integer> comparableNumbers = new ListOfComparableNumbers<>();

    ListOfComparableNumbers<Double> comparableDoubles = new ListOfComparableNumbers<>();

    comparableNumbers.add(1, 3, 9, 7, 2);

    System.out.println(comparableNumbers.sort());

    comparableDoubles.add(0.2, 0.5, 0.1, 0.7);


    // zarówno Integer, jak i Double rozszerzają klasę Number
    System.out.println(comparableNumbers.sum(List.of(1, 2.0, 11, 3.2, new BigDecimal(2.2))));

  }
}
