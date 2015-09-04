# Instalacija Svetovid-lib biblioteke

## Konfigurisanje

Budući da biblioteka nije deo standardne Java Virtualne Mašine,
neophodno je nekako uputiti kompajler da je koristi.

### Eksplicitno navodjenje jar-a pri kompajliranju

Najjednostavniji način da se omogući korišćenje biblioteke je staviti
odgovarajući "jar" fajl u radni direktorijum i pri kompajliranju ga
dodati u putanju klasa:

`javac -cp svetovid-lib.jar Program.java`

### Dodavanje na sistemskom nivou u JVM

No verovatno najbolje rešenje je dodavanjem u spisak biblioteka Java
Virtuelne Mašine, pošto će onda biblioteka biti upotrebljiva u svim
direktorijumima bez dodatnih izmena ili posebnih poziva pri
kompajliranju. Potrebno je samo dodati “svetovid-lib.jar” u `lib/ext`
deljeni direktorijum Java Radnih Okruženja. Ove izmene naravno
zahtevaju da imamo administrativni pristup na konkretnom računaru.

Na Windows operativnom sistemu je to sledeći direktorijum:
 `%SystemRoot%\Sun\Java\lib\ext`

dok je na Linux operativnim sistemima to 
  `/usr/java/packages/lib/ext`

[Više detalja o ext direktorijumu](http://docs.oracle.com/javase/tutorial/ext/basics/install.html)

### Otpakivanje u trenutni direktorijum

Još jedan jednostavan način da se omogući korišćenje biblioteke u jednom
direktorijumu je da se otpakuju svi njeni fajlovi u taj direktorijum.
Ovo je nešto što je uvek moguće ukoliko imamo prava pisanja u tom
direktorijumu, a i kompajliranje se tada obavlja na isti način kao i uvek.

### Dodavanje u editor DrJava

Da bi se u editoru DrJava omogućilo kompajliranje i pokretanje
programa u panela Interactions, najjednostavnije je eksplicitno dodati
`svetovid-lib.jar` u `Classpath` editora, ili otpakovati jar u
trenutni direktorijum kao što je gore navedeno.

U okviru editora se ovo postiže na sledeći način:

 - Edit->Preferences->ResourceLocations->Extra Classpath->Add 

Alternativno se radi istog efekta u fajl `.drjava` u korisničkom
direktorijumu može dodati polje

 ```
 extra.classpath=putanja/svetovid-lib.jar
 ```

Jednom kad se ovo postavi u editoru, podešavanja će važiti za sve
programe koji se pokreću u njemu. Ovo je vrlo pogodno rešenje pošto ne
zahteva administrativne privilegije, jer jar fajl može biti bilo gde
na sistemu.

Ako se koriti metod za dodavanje na sistemskom nivou, programi koji
koriste Svetovid-lib će se kompajlirati uspešno u editoru, ali panel
Interactions će prijavljivati grešku, pošto DrJava nažalost ne uzima u
obzir deljeni ext direktorijum pri pokretanju.


## Testiranje instalacije

Za jednostavno testiranje da li je bibloteka ispravno instalirana i da
li se ispravno vidi od strane java kompajlera je napravljen glavni
metod u klasi `Svetovid` koji ispisuje trenutnu instaliranu verziju.
Najjednostavnije se može izvršiti sledećim pozivom: 

`java Svetovid`

Ako je jar dodat negde gde ga JVM vidi, biće ispisana poruka o verziji
Svetovid biblioteke, a ako nije ispisaće se greška da klasa nije
nađena.
