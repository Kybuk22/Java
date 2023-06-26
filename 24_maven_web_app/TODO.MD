# Zadania

## Zadanie 1

Dodaj serwlet (z wpisem do pliku `web.xml`), który przy żądaniu GET na adres `/time`
zwróci bieżącą datę - `(new Date()).toString()`

## Zadanie 2

Dodaj serwlet (z adnotacją), który będzie sprawdzał, czy liczba przekazana jako parametr `number`
jest parzysta czy nie i będzie zwracać `true` lub `false`.

Aby pobrać parametr z `URL` należy użyć metody `request.getParameter("number")` i zamienić na liczbę.

## Zadanie 3

Dodać filtr, który będzie sprawdzał, czy żądanie ma dodany nagłówek,
`X-MySecureToken` z wartością `1234` jeśli nie, to wyśle do przeglądarki kod błędu 401,
z komunikatem (`Unauthorized User`)  - `res.sendError(...,...)`, jeśli jest dodany
pozwoli na dalsze przetwarzanie.

## Zadanie 4

Do serwletu z zadania 2, dodać obsługę żądnia metodą POST - analogicznie, parametr w formularzu powinien się nazywać
`number` a serwlet też ma zwracać `true` lub `false` jeśli liczba jest parzysta lub nie


## Zadanie 5

Stworzyć serwlet, który obsługuje tylko metodę POST, (metoda GET powinna zwracać błąd 405).
Stworzyć klasę `Person` z polami `name` - `String`, `age` - `Integer`, `over18` - `Boolean`.
W swerwlecie, przyczytać i sparsować żądanie. Ustawić odpowienio pole `over18` - w zależności czy wiek jest
większy od 18 czy nie i wysłać tak zmieniony obiekt do klienta. 
