Učitavanje i ispisivanje
========================

Učitavanje osnovnih tipova podataka sa tastature, odnosno standardnog ulaza, se
može jednostavno postići pomoću metoda iz `Svetovid.in`:

    int a = Svetovid.in.readInt();
    int b = Svetovid.in.readInt();

Metodima se može proslediti i string sa porukom koja će biti prikazana
korisniku:

    int a = Svetovid.in.readInt("Unesite jedan broj:");
    int b = Svetovid.in.readInt("Unesite drugi broj:");

Ispis osnovnih tipova na ekran, odnosno standardni izlaz, je takođe jednostavan
uz korišćenje metoda iz `Svetovid.out`:

    Svetovid.out.println(a + b);

Prilikom ispisivanja se takođe može proslediti prigodna poruka namenjena
korisniku:

    Svetovid.out.println("Zbir je:", a + b);

Prilikom učitavanja podataka potrebno je koristiti `read` metod koji odgovara
tipu podataka koji se traži od korisnika. Na primer

 - `readInt` za `int` (cele brojeve)
 - `readDouble` za realne brojeve duple preciznosti
 - `readBool` za `boolean`,
 - `readLong` za `longint` (celi brojevi u većem opsegu vrednosti),


Za tip `String` (niz znakova) se najčešće koristi sledeći metod:

    String ceoRed = Svetovid.in.readLine();

Prilikom ispisivanja nije potrebno uzimati tip podatka za ime metoda,
pošto postoji po jedan `print` metod za svaki od osnovnih tipova
podataka.

Analogne komande za učitavanje i ispisivanje se mogu naći u okviru klase
`System`, a mogu se koristiti naizmenično sa onima iz klase `Svetovid` bez
ikakvih problema:

    Svetovid.out.println("Prva poruka");
    System.out.println("Druga poruka");
    Svetovid.out.println("Treća poruka");
