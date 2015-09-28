Rad sa fajlovima
================

Čitanje iz fajla
----------------

Čitanje podataka iz tekstualnih fajlova je vrlo slično čitanju podataka sa
standardnog ulaza, [odnosno tastature](ucitavanje-i-ispisivanje.markdown).
Jedina razlika je u tome što se navodi ime fajla iz kojeg se čitaju podaci:

    int broj1 = Svetovid.in("ulazni.txt").readInt();
    int broj2 = Svetovid.in("ulazni.txt").readInt();
    int rezultat = broj1 + broj2;

Fajl će automatski biti otvoren prilikom prvog čitanja u okviru programa, a
čitanje podataka će početi od početka fajla. Ako je fajl već ranije bio otvoren
u okviru programa, čitanje će se nastaviti sa onog mesta na kojem se prethodni
put stalo, odnosno biće učitan naredni podatak.

Ako je potrebno pročitati sve podatke iz tekstualnog fajla, najjednostavniji
način je pomoću `while` petlje i `isEmpty()` metoda:

```java
    double suma = 0;
    while (!Svetovid.in("ulazni.txt").isEmpty()) {
        double broj = Svetovid.in("ulazni.txt").readDouble();
        suma = suma + broj;
    }
    Svetovid.out.println(suma);
```

Kada `isEmpty()` metod vrati `true` u fajlu više nema podataka. Ako je potrebno
ponovo pročitati podatke, potrebno je prvo zatvoriti fajl:

    Svetovid.in("ulazni.txt").close();

Posle zatvaranja fajla, dalje čitanje podataka će automatski otvoriti fajl i
krenuti od njegovog početka. Ako se fajl dalje neće koristiti, nije potrebno
eksplicitno ga zatvoriti pošto se svi otvoreni fajlovi automatski zatvaraju na
kraju rada programa.

Pisanje u fajl
--------------

Upisivanje podataka u tekstualni fajl je vrlo slično ispisivanju podataka na
standardni izlaz, [odnosno ekran](ucitavanje-i-ispisivanje.markdown). Jedina
razlika je u tome što se navodi ime fajla u koji se podaci upisuju:

    Svetovid.out("izlazni.txt").println("Poruka");

Ako navedeni fajl nije postojao, automatski će biti napravljen, a ako je fajl
već postojao, sav njegov sadržaj će biti zamenjen ovim tekstom. Svako naredno
pisanje u isti fajl će zadržati njegov prethodni sadržaj, odnosno upisivaće
naredni podatak u nastavku.

    Svetovid.out("izlazni.txt").println("Malo duža poruka");
    Svetovid.out("izlazni.txt").println("u dva reda");

Ukoliko želimo da u već postojećem fajlu zadržimo sadržaj koji je postojao pre
pokretanja programa i samo dopišemo nove podatke na kraj, to možemo lako uraditi
korišćenjem `append` umesto `out` na sledeći način:

    Svetovid.append("izlazni.txt").println("Nastavak poruke");

Ako se u fajl dalje neće upisivati, nije potrebno eksplicitno ga zatvoriti pošto
se svi otvoreni fajlovi automatski zatvaraju na kraju rada programa.
