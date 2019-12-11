# kambu-coding-task

Currency converter.
1. Opis projektu:
Aplikacja korzysta z zewnetrznego serwera pobierajacego informację odnośnie kursów walut.
Technologie użyte: Java, Mysql,Spring
W projekcie znajduję się zwagger tworzący automatycznie dokumentację projektu.

2. Wymagania przed uruchomieniem - Java, Mysql

3. Opis endpointów:
  - http://localhost:8080/currency/availableCurrencies - wywołanie tego endpoint'a skutkuje zwróceniem listy 
  walut na których możemy wykonywać operacje konwertowania.
  
  - http://localhost:8080/currency/currenciesValues - zwraca dostępne wauty, wraz z ich wartościami.
  
  - http://localhost:8080/currency/convertCurrency/{amount}/{currencyFrom}/{currencyTo} - w tym endpoint'cie należy podać trzy parametry
  amount- ilość danej waluty, currencyFrom- z jakiej waluty konwertujemy , currencyTo- do jakiej waluty konwertujemy, endpoint zwraca
  ilosc waluty wynikowej.
  
  Przykładowe wywołania:
    - http://localhost:8080/currency/convertCurrency/200/USD/AUD
    
   - http://localhost:8080/currency/availableCurrencies
    
   - http://localhost:8080/currency/currenciesValues
  
 


