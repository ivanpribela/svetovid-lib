# Instalacija Svetovid-lib biblioteke

## Konfigurisanje

Budući da biblioteka nije deo standardne Java Virtualne Mašine,
neophodno je nekako uputiti kompajler da je koristi.

### Otpakivanje u trenutni direktorijum

Najjednostavniji način da se omogući korišćenje biblioteke u jednom
direktorijumu je da se otpakuju svi njeni class fajlovi u taj
direktorijum. Ovo je nešto što je uvek moguće ukoliko imamo prava
pisanja u tom direktorijumu, a i kompajliranje se tada obavlja na isti
način kao i uvek.

### Dodavanje jar-a eksplicitno pri kompajliranju

Takođe je moguće staviti odgovarajući "jar" fajl u direktorijum i pri
kompajliranju ga dodavati u putanju klasa:

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
