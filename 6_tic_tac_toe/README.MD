# Kółko i krzyżyk

## Zasady 

Zasady gry są powszechnie znane. Gracze na przemian stawiają na planszy 3 x 3, swoje symbole (X lub O).
Wygrywa gracz, który jako pierwszy postawi 3 takie same znaki w linii poziomej, pionowej
lub po skosie. Gra może zakończyć się zwycięstwem jednego z graczy lub remisem.

## Funkcjonalność

Aplikacja umożliwia granie w grę kółko i krzyżyk. Pozwala stawiać kolejne znaki na planszy, jednocześnie
weryfikując czy dany ruch jest prawidłowy.
Aplikacja ma metody pozwalające sprawdzić zwycięzcę oraz który znak jest następny.

Dodatkowo aplikacja pozwala rozpocząc grę z początkowymi ruchami - konstruktor przyjmuje inicjalną listę ruchów które.
Dzięki temu konstruktorowi możliwe jest również przekazanie pełnej listy ruchów tak, by aplikacja sprawdziła kto wygrał.

## Zadania

1. Zaimplementuj wszystkie metody z interfejsu [`TicTacToe`](src/main/java/edu/technischools/java/tic/TicTacToe.java)
w klasie  [`Game`](src/main/java/edu/technischools/java/tic/Game.java);
   
2. Aby przetestować czy twój kod działa, możesz użyć klasy [`PlayTicTacToe`](src/main/java/edu/technischools/java/tic/PlayTicTacToe.java) 

3. Uzupełnij test [`GameTest`](src/test/java/edu/technischools/java/tic/GameTest.java), tak by przetestować stworzone metody.

4. Napisz metody testowe, które znajdą zwycięzcę, dla gry zainicjowanej już ruchami.
