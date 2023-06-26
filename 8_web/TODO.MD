# Zadanie

Zadanie polega na stworzeniu prostego kalkulatora, który potrafi dodawać, odejmować, mnożyć i dzielić 
dwie liczby zmiennoprzecinkowe.
Staraj się stosować dobre praktyki programowania
 * odpowiednie nazwy zmiennych
 * samo-komentujący się kod
 * metody i klasy mające jedną odpowiedzialność
 *  


## 1. Model danych

W pakiecie `edu.technischools.java.model` stwórz klasę `Equation` która będzie miała pola:
  * `operandA` typu `Double`
  * `operandB` typu `Double`
  * `operation` typu `enum` z opcjami `ADD`, `SUB`, `MUL`, `DIV` 
  * `result` typu `Double`
  * `error` typu `String`

Pola `operandA` i `operandB` będą przechowywać liczby, na których chcemy wykonać działanie.
Pole `operation` to typ operacji, jaką chcemy wykonać - `ADD` - dodawanie, `SUB` - odejmowanie, `MUL`  - mnożenie i `DIV` dzielenie 
Pole `result` będzie zawierać wynik operacji 
Pole `error` będzie zawierać ew błąd-np. próba dzielenia przez 0 lub nieprawidłowa operacja (inna wartość niż dozwolone `ADD`,`SUB`,`MUL`,`DIV`) 

Dodaj gettery i settery do wszystkich pól
                       

## 2. Serwis 

Klasa `edu.technischools.java.service.Calculator` odpowiedzialna jest za wykonywanie obliczeń.

Uzupełnij metodę `compute` tak by na podstawie przekazanego parametru `opertaion` wykonywała zadanie.

Metoda powinna rzucać wyjątek (`edu.technischools.java.service.ComputationException`) z odpowiednim komunikatem, jeśli próbujemy
 * wykonać dzielenie przez 0 
 * wykonać działanie, które nie jest wspierane (`ADD`, `SUB`, `MUL`, `DIV` ) 
 * którykolwiek z parametrów jest `null`

Zmodyfikuj kod klasy `Calculator` tak by była ona singletonem.

Napisz test do klasy `Calculator` - umieść go w odpowiednim katalogu i miejscu. Przed napisaniem testu dodaj zależność 
   * grupa -`junit`
   * artefakt - `junit`
   * wersja - `4.13.1`

Test powinny sprawdzić poprawne działanie metody, jak i 2 z 3 przypadków błędnych (takie, które rzucają wyjątek).

## 3. Web
             
Dodaj servlet `edu.technischools.java.web.CalculatorServlet`, zdefiniowany pod URL `/api/calculate`.

W serwlecie dodaj obsługę dla metod `GET` i `POST`, które będą używały klasy z zadania 2 do obliczeń.
  * dla metody `GET` parametry powinny być przekazane poprzez odpowiednie parametry adresu (nazwy parametrów mogą być takie same jak nazwy pól w modelu)
    * metoda powinna zwracać:
      1. wynik działania (sama wartość), gdy nie ma błędu
      2. komunikat o błędzie z wyjątku (sam tekst), gdy wystąpił błąd
      
  * dla metody `POST` parametry powinny być przekazane jako `JSON` klasy `Equation` z zadania 1, 
do stworzenia JSONa użyć biblioteki `jackson`(dodana jako zależność)
    * metoda powinna zwracać `JSON` z dodatkowo wypełnionymi odpowiednimi polami 
      1. `result`  z wynikiem działania, gdy nie ma błędu
      2. `error` z komunikatem o błędzie z wyjątku, gdy wystąpił błąd 

**(*)** Dla chętnych, zdefiniować serwlet na URL `/api/calculate/*` a operację przekazać jako URL, czyli np.
 * `/api/calculate/add` 
 * `/api/calculate/div` 
Pomijając `operation` w JSONie i parametrach zapytania.
URL można pobrać w serwlecie używając metody (`HttpServletRequest.getRequestURI()`)

Przetestuj obie metody `GET` i `POST` - możesz użyć przeglądarki, Postmana lub HTTP Client z Idei 

## 4. Maven 

Zbuduj aplikację, tak by stworzył się plik `war`.


