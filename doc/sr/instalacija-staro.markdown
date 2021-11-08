# Stara uputstva za instalacije

Ova uputstva se ne mogu primenjivati na najnovije verzije
jezika Java, ali su ostavljena ovde za svaki slučaj.

## Dodavanje na sistemskom nivou u JVM (do verzije 8)

*Ova mogućnost je dostupna samo na verzijama Jave do i
uključujući 8. Na kasnijima je izbačen ovaj folder za biblioteke iz
standarda.*

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

**Napomena:** Ako je biblioteka instalirana na sistemskom nivou, ta
verzija će biti učitana i koristiće se uvek. Ako se pokušaju korisiti
drugi metodi kao što je navođenje jar-a pri kompajliranju i
otpakivanje u trenutni direktorijum oni će biti ignorisani.

## Dodavanje u editor *DrJava*

*Ovaj editor ne radi ispravno ukoliko nema kompajler za Javu verzije 8
ili ranije, pa više nije među preporučenim izborima.*

Da bi se u editoru DrJava omogućilo kompajliranje i pokretanje
programa iz panela Interactions, neophodno je nekako obavestiti
editor o postojanju ove dodatne biblioteke.

Najjednostavnija varijanta je nabavljanje verzije editora u kojoj
je već intergrisana biblioteka "svetovid-lib". Na [sajtu biblioteke](http://svetovid.org/lib/)
se mogu naći ovako pripremljeni jar fajlovi sa najnovijom stabilnom
verzijom biblioteke.

Naravno moguće je koristiti i neizmenjeni editor. Tada je potrebno
eksplicitno dodati `svetovid-lib.jar` u `Classpath` editora, ili
otpakovati jar u trenutni direktorijum kao što je gore navedeno.

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
Interactions će prijavljivati grešku, pošto DrJava, nažalost, ne uzima u
obzir deljeni ext direktorijum pri pokretanju.
