# Sprawdzian 2

```
2	40%	 10   ->  14
3	51%	 15   ->  21
4	75%	 22   ->  26
5	90%	 27   ->  28
6	98%	 29   ->  30
```

------------------

1. W klasie `Barcode` uzupełnić klasę `Builder` która będzie pozwalała zbudować obiekt typu `Barcode`. [3]

2. Dodać do klasy `Parcel` gettery oraz konstruktor ze wszystkimi polami. [1] 

3. Zmienić metodę `ParcelService.createParcel` tak by na zwracała obiekt `Parcel` z uzupełnionymi polami. [1]

4. Zmienić metodę `ParcelService.createEnvelope` tak by na zwracała obiekt `Envelope` zupełnionymi polami. [1]

5. W konstruktorze klasy `Shipment` odkomentować kod budujący obiekt klasy `Barcode` oraz dodać brakujące metody,
   tak by stworzyć obiekt klasy `Bardode` ze wszytskimi polami. [2]

6. Stworzyć wyjątek `InvalidStatusException` dziedziczący z klasy `ShipmentException` oraz dodać go deklaracji metody `Shipment.moveToStatus`. Uzupełnić metodę `moveToStatus` tak by nie pozwlała zmienić statusu z `PREPARED` na `DELIVERED`. (aktualny status znajduje się zawsze na ostatnim miejscu w liście statusów). [4]

7. Dodać deklarację wyjątku z 6. do metod `ShipmentService.transit` oraz `ShipmentService.deliver`. [1]

8. W klasie `ShimpentService` dodać brakującą metodę, tak by serwis był singletonem. Dodać odpowiedni konstruktor. [2]

9. Uzupełnić metody `TrackingService.findByStatus` oraz `TrackingService.findByUUID` tak by, zwracały odpowienie listy obiektów. Do filtrowania użyć streamów. [3]

10. Dodać do metod `TrackingService.findByStatus` oraz `TrackingService.findByUUID` deklarację wyjątku `ShipmentNotFoundException` oraz rzucić ten wyjątek gdy nie znaleziono przesyłek o podanym statusie lub podanym `UUID`. [3]

11. Odkomentować 3 linie od  lini z `TODO 11` w klasie `ParcelShop`.

12. Odkomentować linię pod `TODO 12` oraz uzupełnić metodę `createParcel` tak by stworzyć obiekt klasy `Parcel`.
Odkomentować kolejną linię oraz uzupełnić metodę `createEnvelopw` tak by stworzyć obiekt klasy `Envelope`. [2]

1.  Odkomentować 2 kolejne linie pod `TODO 13`. Stworzyć klasę `ParcelAdapter`, która będzie adapterem pomiędzy klasami `Parcel` i `Envelope`. [3]

2.  Odkomentować linię pod `TODO 14`.

3.  Odkomentować linię pod `TODO 15`, dodać obsługę wyjątku - złapać go i wypisać na konsolę. [2]

4.   Odkomentować linię pod `TODO 15`, używając streamów wypisać na konsolę pole `data` z obiektów `barcode` dla każdej przesyłki. [2]
