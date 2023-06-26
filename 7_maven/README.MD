# Maven

1. Dodaj zależność do biblioteki `guava`
    * grupa : `com.google.guava`
    * artefakt: `guava`
    * wersja `31-jre`
2. Uruchom mavena (z lini poleceń lub z Idei), żeby sprawdzić, czy kod się kompiluje (`compile`)
3. Dodaj zależność testowa dla biblioteki `junit`
    * grupa : `junit`
    * artefakt: `junit`
    * wersja `4.13.1`
4. Napisz testy dla klasy `Sorter`
5. Uruchom testy używając mavena, faza `test`
6. Zbuduj aplikację, tak by powstał plik `.jar`
7. Uruchom aplikację z lini poleceń używając polecenia `java -jar <nazwa_pliku>.jar`
8. Zainstaluj artefakt w lokalnym repozytorium używając `mvn install`
9. Zmień wersję na releasową (tzn. usuń `-SNAPSHOT`)
10. Zainstaluj artefakt ze zmienioną wersją w lokalnym repozytorium
11. Spróbuj zrobić to ponownie

