#### Przeszukiwanie ciągów znaków

Napisz program który pobiera dwa argumenty z linii poleceń, ciągi znaków. Program sprawdza czy drugi ciąg znaków jest podciągiem pierwszego (nie wolno używać substr, substring ani innej funkcji standardowej w tym również bibliotek wyrażeń regularnych).
+ Jeden warunek: każde wystąpienie * w drugim ciągu oznacza dopasowanie do zera lub więcej znaków pierwszego ciągu. Jeśli wejściem do programu były ciągi abcd oraz a*c, wtedy drugi ciąg liczy się jako podciąg pierwszego. 
+ Dodatkowa funkcjonalność to zezwolenie na traktowanie gwiazdki jako normalny znak jeśli jest poprzedzona znakiem \, natomiast znak \ jest traktowany normalnie oprócz sytuacji gdy poprzedza gwiazdkę.
