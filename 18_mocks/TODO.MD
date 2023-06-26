1. Uzupełnić metody testowe w klasie `AccountServiceTest`, tak by testowały metody z klasy `AccountService` zgodnie z
   nazwą metody testowej.
   Zamockować `AccountNumberGenerator`, tak by zawsze zwracał tą samą wartość-tak aby można było sprawdzić wszystkie
   pola obiektu `Account` stworzonego przez serwis


2. Do testu `ClientServiceTest` dopisać metody testowe dla:
    * `findClientById` - przypadek poprawny i braku blienta o podanym id
    * `findAll`


3. Uzupełnić `BankTest`, tak by przetestować metody:
    * `addNewClient`
    * `setupNewAccount`
    * `transferMoney` - obie wersje
