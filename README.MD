REST API do zarządzania domową apteką
======
Opis
-----
API udostępnia żądania pozwalające dodawać, modyfikować, usuwać oraz wyświetlać rekordy z bazy danych Apteka.
Użytkownik może wyświetlić całą listę leków/miejsc składowania leków. Może też wyświetlić pojedynczy lek, wraz ze szczegółami.

Sposób uruchomienia aplikacji
=====
Aplikacja wykorzystuje bazę danych PostgreSQL więc jest on konieczny do działania aplikacji.
Po pobraniu repozytorium nalży odpowiednio skonfigurować application.properties
Źródło: \src\main\resources\application.properties
1. spring.datasource.url=(adres bazy danych/nazwę bazy)
2. spring.datasource.username=(nazwa użytkownika bazy)
3. spring.datasource.password=(hasło użytkownika bazy)
Właściwość spring.jpa.hibernate.dll-auto=create sprawia, 
że po ponownym uruchomieniu aplikacji tabele w bazie zostaną usunięte i stworzone na nowo, a tabele będą początkowo puste.
Żeby temu zaradzić przed następnym uruchomieniem aplikacji należy właściwość tą zmienić na
spring.jpa.hibernate.dll-auto=none

Preferowanym sposobem uruchomienia aplikacji jest za ponocą IDE lub stworzenie .jar za pomocą Mavena. 
Po uruchomieniu aplikacja powinna stworzyć tabele oraz pozwoli modyfikować bazę lub wyświetlać rekordy
(o ile application.properties zostało dobrze skonfigurowane).

Aplikacja wysyła odpowiedzi w formacie JSON oraz korzysta domyślnie z portu 8080, np:
`http://localhost:8080/medicaments`


Podczas tworzenia aplikacji wykorzystywany był program Postman.

Dokumentacja API
=====
`GET: /medicaments` - Wyświetlenie wszystkich leków

`GET: /medicaments?id={id}` - Szczegółowe wyświetlenie informacji o leku posiadającym id={id} (o ile
lek z takim id istnieje, w przeciwnym wypadku wyświetlenie wszystkich leków z bazy.

`GET: /medicaments/{page}` - Wyświetlnienie listy dwóch wyników, za pomocą liczby {page} można wertować wyniki.

`POST: /medicaments?name={name}&date={date}&location={location}` - dodanie nowego leku do bazy. 
Wartość name oznacza nazwę leku.
Date jest datą ważności leku, zapisaną w formacie RRRR-MM-DD.

`PUT: /medicaments?id={id}&new-name={new-name}&new-date={new-date}&new-location={new-location}` - Zmiana na nowy lek.
Wartość id oznacza numer id w leku, który ma być zmieniony. 
Wartość new-name to nowa nazwa leku.
Wartość new-date oznacza nową datę ważności dla leku.
Wartość new-location oznacza numer id miejsca składowania leku

`DELETE: /medicaments?id={id}` - usunięcie leku z bazy.
Wartość id oznacza numer id leku.

`GET: /locations` - Wyświetlenie listy wszystkich miejsc składowania leku.

`GET: /locations?id={id}` - Pobranie pojedynczego rekordu z bazy locations o podanym id. Jeżeli takie id nie istnieje, 
pobierana jest lista wszystkich rekordów z bazy locations.

`POST: /locations?name={name}` - Dodanie nowego miejsca składowania leku.

`PUT: /locations?id={id}&name={name}` - Zmiana rekordu o podanym id.

`DELETE /locations?id={id}` - Usunięcie rekordu z bazy danych oraz innych rekordów z nim powiązanych
(z bazy medicaments).
