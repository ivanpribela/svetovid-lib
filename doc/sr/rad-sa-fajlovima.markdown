Rad sa fajlovima
================

Čitanje iz fajla
----------------

Čitanje podataka iz tekstualnih fajlova je vrlo slično čitanju podataka sa
standardnog ulaza, [odnosno tastature](ucitavanje-i-ispisivanje.markdown).
Jedina razlika je u tome što se navodi ime fajla iz kojeg se čitaju podaci:

```java
    int broj1 = Svetovid.in("ulazni.txt").readInt();
    int broj2 = Svetovid.in("ulazni.txt").readInt();
    int rezultat = broj1 + broj2;
```

Fajl će automatski biti otvoren prilikom prvog čitanja u okviru programa, a
čitanje podataka će početi od početka fajla. Ako je fajl već ranije bio otvoren
u okviru programa, čitanje će se nastaviti sa onog mesta na kojem se prethodni
put stalo, odnosno biće učitan naredni podatak.

Ako je potrebno pročitati sve podatke iz tekstualnog fajla, najjednostavniji
način je pomoću `while` petlje i `hasMore()` metoda:

```java
    double suma = 0;
    String ulaz = "ulazni.txt";
    while (Svetovid.in(ulaz).hasMore()) {
        double broj = Svetovid.in(ulaz).readDouble();
        suma = suma + broj;
    }
    Svetovid.out.println(suma);
```

Kada `hasMore()` metod vrati `false` u fajlu više nema podataka.
Postoji i analogan metod `isEmpty()`.

Ako je potrebno ponovo pročitati podatke od početka fajla, potrebno je
prvo zatvoriti fajl:

    Svetovid.in("ulazni.txt").close();

Posle zatvaranja fajla, dalje čitanje podataka će automatski otvoriti fajl i
krenuti od njegovog početka. Ako se fajl dalje neće koristiti, nije potrebno
eksplicitno ga zatvoriti pošto se svi otvoreni fajlovi automatski zatvaraju na
kraju rada programa.

Pre čitanja je moguće proveriti i da li je fajl dostupan za čitanje
(odnosno da li postoji i da li imamo prava da ga čitamo) koristeći metod
`Svetovid.testIn`. Na primer:

```java
    if (Svetovid.testIn("ulazni.txt")) {
       // citanje fajla
    } else {
      Svetovid.out.println("Fajl nije dostupan za citanje");
    }
```


Pisanje u fajl
--------------

Upisivanje podataka u tekstualni fajl je vrlo slično ispisivanju podataka na
standardni izlaz, [odnosno ekran](ucitavanje-i-ispisivanje.markdown). Jedina
razlika je u tome što se navodi ime fajla u koji se podaci upisuju:

```java
    Svetovid.out("izlazni.txt").println("Poruka");
```

Ako navedeni fajl nije postojao, automatski će biti napravljen, a ako je fajl
već postojao, sav njegov sadržaj će biti zamenjen ovim tekstom. Svako naredno
pisanje u isti fajl će zadržati njegov prethodni sadržaj, odnosno upisivaće
naredni podatak u nastavku.

```java
    Svetovid.out("izlazni.txt").println("Malo duža poruka");
    Svetovid.out("izlazni.txt").println("u dva reda");
```

Ukoliko želimo da u već postojećem fajlu zadržimo sadržaj koji je postojao pre
pokretanja programa i samo dopišemo nove podatke na kraj, to možemo lako uraditi
korišćenjem `append` umesto `out` na sledeći način:

```java
    Svetovid.append("izlazni.txt").println("Nastavak poruke");
```

Izlazni fajl se može eksplicitno zatvoriti sa

```java
    Svetovid.out("izlazni.txt").close();
```

Svi fajlovi otvoreni korišćenjem ove biblioteke se automatski
zatvaraju na kraju rada programa, tako da često nije neophodno
eksplicitno ih zatvarati. Međutim budući da se relativno često može
desiti da su fajlovi potrebni drugim programa pre nego što naš završi
sa radom (naročito čest slučaj kod grafičkih programa) uglavnom se
preporučuje eksplicitno zatvaranje fajla čim je završeno pisanje u
njega.

Analogno sa čitanjem, moguće je proveriti da li je fajl dostupan za pisanje
(odnosno da li postoji i da li imamo prava da pišemo u njega) koristeći metod
`Svetovid.testOut`. Na primer:

```java
    if (Svetovid.testOut("izlaz.txt")) {
       // pisanje u fajl
    } else {
      Svetovid.out.println("Nije moguce pisati u fajl");
    }
```
