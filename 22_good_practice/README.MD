## Clean code

1. Konwencje nazewnicze 
    1. znaczące nazwy 
    ```java         
     int d; //time in days
    ``` 
   vs
   ```java         
     int elapsedDays; 
    ```             
   2. nazwy klas powinny być rzeczownikami
   ```java
   public class Customer {...}
   public class Address {...}
    ```
   3. nazwy metod powinny zawierać czasownik, 
   ```java                                   
      saveAccount();   
   ```              
   4. jedna konwencja nazewnicza-ie. `get/fetch/retrive` 

2. Metody
   1. małe-metoda powinna się mieścić na ekranie
   2. pojedyncza odpowiedzialność-metoda powinna robić, jedną i tylko jedną rzecz
   3. ilość argumentów-2,3,4
   4. nie mogą mieć efektów ubocznych ("side-effects")
   5. wyjątki, nie kody błędów
   6. unikaj pustych bloków `catch(){}` 
   7. nie powinny zwracać `null`
      ```java
        List<Integer> list = new ArrayList<>;
         ...   
        return null;
      ```
      vs
      ```java   
         List<Integer> list = new ArrayList<>;
         ...
         return  list;
      ```                
      
3. Samokomentujący się kod
   1. komentarze w kodzie, są "praktycznie" zbędne
4. Formatowanie
5. Hermetyzacja
   1. zmienna prywatne
   2. dostęp przez gettery i settery z odpowiednim dostępem (`public`/`protected`)

## SOLID  
* **S**ingle Responsibility
* **O**pen/Closed
* **L**iskov Substitution
* **I**nterface Separation
* **D**ependecy Injection

## DRY 
   Don't Repeat Yourself 
## KISS 
   Keep It Simple Stupid
