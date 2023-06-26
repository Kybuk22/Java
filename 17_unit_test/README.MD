# Testy Jednostkowe (Unit Tests)

## Co to są testy jednostkowe ?

Testy jednostkowe służą do testowania/weryfikacji pojedynczych funkcjonalności programu-testujemy pojedyncze metody.
Testy jednostkowe zawsze testują pojedynczą funkcjonalność, nie sprawdzają poprawności całego procesu, np od kliknięcia przez użytkownika
do zapisu do bazy-tym zajmują się testy e2e (end to end) i testy integracyjne.


## Co testujemy w testach jednostkowych ?

Testy jednostkowe polegają na wykonaniu metody z określonymi parametrami i sprawdzeniu, czy wynik jest zgodny z oczekiwanym.
Poza scenariuszami pozytywnymi powinniśmy sprawdzać również scenariusze negatywne, np. błędne parametry, które powodują rzucenie wyjątku.

## JUnit

[JUnit](https://junit.org/) jest frameworkiem testowym powszechnie używanym w Javie.

### Testy w JUnit

Pliki testów są zwykłymi klasami w Javie. Klasy testów grupują testy dla poszczególnych 
klas z naszej aplikacji.

Najprostszy test JUnit wygląda tak:

```java
 import org.junit.Assert;
 import org.junit.Test;

 public class SimpleTest {
  
  @Test
  public void test2Equals2() {
    int a = 2;
    Assert.assertEquals(2, a);
  }
}
```

Każda metoda, która ma być testem musi być zaadnotowana `@Test`.
W ciele metody wywołujemy kod, który chcemy wykonać, a na koniec sprawdzamy, czy otrzymany wynik jest zgodny
z założonym.

Do weryfikacji służy klasa `Assert`, posiada ona metody pozwalające sprawdzić, czy otrzymany wynik jest:
* równy założonemu - `assertEquals`
* równy `null` - `assertNull`
* prawdziwe jest wyrażanie `assertTrue`
              
Jeśli chcielibyśmy przetestować czy metoda rzuca wyjątek, wówczas do adnotacji `@Test` dodajemy parametr 
expected z oczekiwaną klasą wyjątku. Taki test nie musi mieć assercji (metod `assert*`). 
                                                                                      

Jeśli chcemy przygotować nasz kod do testu, ustawić odpowienie zmienne i zależności robimy to w metodzie z adnotacją
`@Before`. Najczęściej taka metoda będzie miała nazwę `setUp`. 

### Konwencja nazewnicza

Klasa z testami powinna nazywać się tak jak nasza klasa z przyrostkiem `Test`, Na przykład dla klasy `Calculator`,
klasa testu powinna nazywać się `CalulatorTest`. Klasy testów powinny być w tym samym pakiecie co klasy testowane, ale
w katalogu `src\test\java`.

Nazwy metod powinny zaczynać się od słowa `test` , nazwy metody, którą testujemy oraz opisu co testujemy.
Zasada jest, że jeden test — jedna weryfikacja poprawności.
Dla naszej klasy `Calculator` i metody `divide`, powinniśmy mieć testy:

* `testDivideByNonZeroNumber` - metoda testująca dzielenie przez liczbę niebędącą zerem — sprawdzamy pozytywny scenariusz  
* `teztDivideByZero` - metoda testująca dzielenie przez 0 - obsługę wyjątku `DivisonByZeroException`
