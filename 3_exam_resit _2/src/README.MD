# Sprawdzian 3

## Zadanie 1 [4 + 3 + 3]

Kod znajduje się w pakiecie `edu.technischools.java.one`.

1. Dopisz testy dla wszystkich metod w klasie [`edu.technischools.java.one.StringUtils`](main/java/edu/technischools/java/one/StringUtils.java) - 
   testy dodaj do klasy  [`edu.technischools.java.one.StringUtilsTest`](test/java/edu/technischools/java/one/StringUtilsTest.java).

   a. Wymagane pokrycie kodu dla metod wszystkich metod - 100%.  

2. Popraw klasę testu [`edu.technischools.java.one.InventoryTest`](test/java/edu/technischools/java/one/InventoryTest.java), tak by test `testAddAndRemoveFlow` przechodził bez błędów.

3. Dopisz pozostałem metody testowe dla metod `testAddOnce` (jednokrotne dodanie elementu) i `testAddMultipleTimes` (wielokrotne dodanie tego samego elementu).

                      
## Zadanie 2 [4 + 6]

Kod znajduje się w pakiecie `edu.technischools.java.two`.

1. Dopisz metody testowe w klasie [`edu.technischools.java.two.DatabaseTest`](test/java/edu/technischools/java/two/DatabaseTest.java) zgodnie z nazwami metod

2. Dopisz metody testowe w klasie [`edu.technischools.java.two.ClientServiceTest`](test/java/edu/technischools/java/two/ClientServiceTest.java) zgodnie z nazwami metod.  
    * użyj mocka dla klasy [`edu.technischools.java.two.Database`](main/java/edu/technischools/java/two/Database.java) tak by nie używać rzeczywistej implementacji
    * zweryfikuj w teście, że wywołane zostały odpowiednie metody z klasy [`edu.technischools.java.two.Database`](main/java/edu/technischools/java/two/Database.java),
    * dla metody testowej `testCreateClient` przechwyć parametr, jaki został przekazany do obiektu `database` i porównaj jego pola z parametrami metody serwisu 
    
    
## Zadanie 3 [3 + 2 + 2 + 3]

Kod znajduje się w pakiecie `edu.technischools.java.three`.
                                                                                                 
1. Zmień klasy [`AscendingSortStrategy`](main/java/edu/technischools/java/three/AscendingSortStrategy.java), [`DescendingSortStrategy`](main/java/edu/technischools/java/three/DescendingSortStrategy.java) i
[`NoSortStartegy`](main/java/edu/technischools/java/three/NoSortStartegy.java), tak by implementowały wspólny interfejs `SortStartegy`

2. Zmodyfikuj konstruktor klasy [`Sorter`](main/java/edu/technischools/java/three/Sorter.java) tak by przyjmował jako parametr strategię i listę do posortowania

3. Zaimplementuj metodę `sort`, tak by sortowała listę używając podanej strategii

4.  W klasie [`SorterTest`](test/java/edu/technischools/java/three/SorterTest.java) napisz metody testowe zgodnie z ich nazwami
