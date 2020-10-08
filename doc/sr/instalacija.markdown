# Instalacija Svetovid-lib biblioteke


## Konfigurisanje

Budući da biblioteka nije deo standardne Java Virtualne Mašine,
neophodno je nekako uputiti kompajler da je koristi. Dalje je navedeno
nekoliko načina da se biblioteka koristi direktno sa kompajlerom, kao
i dodatne napomene za neke editore, a na kraju je naveden i
jednostavan način za testiranje da li je biblioteka adekvatno
instalirana.

### Korišćenje skriptova za instalaciju

U okviru arhive na sajtu bi trebalo da se nalazi `jar` fajl koji je
sama biblioteka, kao i skriptovi koji služe za instaliranje na nekim
operativnim sistemima. Oni će instalirati biblioteku tako da se može
koristiti bilo gde na sistemu, i trebalo bi da samo radi u većini
alata koji služe za pisanje Java programa.

Zainteresovani za detalje kako ovo funkcioniše mogu potražiti niže
objašnjenja koja se tiču `CLASSPATH`-a.

Neki od kompleksnijih alata, kao što je Eclipse, koji insistiraju na
korišćenju projekata za pisanje programa često ne koriste sistemska
podešavanja već su neophodna ručna doterivanja. Za to preporučujemo da
pogledate sekcije niže.


### Eksplicitno navodjenje jar-a pri kompajliranju

Najjednostavniji način da se omogući korišćenje biblioteke je staviti
odgovarajući "jar" fajl u radni direktorijum i pri kompajliranju ga
dodati u putanju klasa:

`javac -cp svetovid-lib.jar Program.java`

Slično je potrebno navoditi jar i pri pokretanju programa:

`java -cp svetovid-lib.jar Program`


### Otpakivanje u trenutni direktorijum

Još jedan jednostavan način da se omogući korišćenje biblioteke u jednom
direktorijumu je da se otpakuju svi njeni fajlovi u taj direktorijum.
Ovo je nešto što je uvek moguće ukoliko imamo prava pisanja u tom
direktorijumu, a i kompajliranje se tada obavlja na isti način kao i uvek.

Mana ovog pristupa je što se "zagađuje" radno okruženje izvornim
fajlovima koji nisu striktno deo trenutnog programa, ali je za neka
brza isprobavanja funkcionalno rešenje.


### Dodavanje u `CLASSPATH`

Java koristi sistemsku promenljivu `CLASSPATH` da nalazi sve
biblioteke.  Ona se može promeniti za trenutnog korisnika, ili za sve
korisnike. Ukoliko se u ovaj spisak doda putanja do "jar" fajla, tada
će svi pozivi i za kompajliranje i za pokretanje Java programa
koristiti ovu biblioteku kad je potrebno. U suštini je ekvivaletno sa
gore pomenutim metodom koji koristi `-cp` parametar, odnosno efekat je
kao da se uvek navodi i ova biblioteka.

Ova opcija je jako dobra jer nije neophodno pojedinačno nameštanje
različitih editora da koriste biblioteku.

U okviru zipa koji se može skinuti sa sajta su stavljeni skriptovi
za upravo ovakvu instalaciju, pa se preporučuje njihova upotreba.

Naravno, napradni korisnici možda žele da još prilagode kako se
skriptovi ponašanju. Njima preporučujemo traženje adekvatnih uputstava
za korisnikov operativni sistem za detalje kako se ovo može najbolje
uraditi.

Takođe u tom slučaju preporučujemo da se biblioteka drži na nekom
stalnom i logičnom mestu, na primer direktno u korenu korisničkog
foldera, ili u nekom podfolderu tipa `lib`.


### Podešavanje editora *Geany*

Editor Geany ima podršku za kompajliranje Java fajlova koja je aktivna
čim se otvori neki fajl sa `.java` ekstenzijom. Podrazumevano se
koristi već instalirana Java, tj alati `java` i `javac`. Ukoliko u
njima već nekako nije podešeno da se koristi biblioteka (npr preko
`CLASSPATH`), moguće je modifikovati pozive da koriste `-cp` parametar
kao što je već ranije opisano.

Za promene kako se radi sa Java fajlovima potrebno je otvoriti odgovarajući
konfiguracioni fajl:

- meni `Tools->Configuration Files->Filetype configuration->Programming Languages->filetypes.java`

- na kraju fajla postoje dve stavke, jedna za kompajliranje, a druga
za pokretanje, potrebno je u obe dodati putanju do biblioteke.

Na primer, ako smo pod Linux-om i bibloteka je u korisničkom "home"
folderu (tipično `/home/korisnik/`), prepraviti komande ovako nekako:

```
compiler=javac -cp .:$HOME/svetovid-lib.jar "%f"
run_cmd=java -cp .:$HOME/svetovid-lib.jar "%e"
```

Slično, ako smo pod Windows-om i ostavili smo fajl u svom korisničkom
folderu (tipično `C:\Users\korisnik\`) onda komande treba da su ovako
nešto

```
compiler=javac -cp .;%HOMEPATH%/svetovid-lib.jar "%f"
run_cmd=java -cp .;%HOMEPATH%/svetovid-lib.jar "%e"
```


### Dodavanje u *Eclipse* razvojno okruženje

Korišćenje biblioteke u okviru razvojnog okruženja Eclipse bi trebalo
da funkcioniše bez ikakvih dodatnih podešavanja ako je biblioteka
instalirana na nivou sistema. Alternativno se biblioteka može dodati u
`classpath` pojedinačnog projekta.

Ukoliko okruženje prijavljuje greške da ne može da nađe klasu Svetovid
(ili neku drugu iz biblioteke) potrebno je naterati ga da osveži svoj
spisak biblioteka. Naime čini se da Eclipse pri dodavanju Java
virtuelnih mašina zapamti sve bibilioteke koje su bile na raspolaganju
da ne bi svaki put ponovo tražio. Zbog ovoga može da dođe do situacija
da se biblioteka `svetovid-lib` čak i nalazi u spisku biblioteka koje
Eclipse izlistava sa strane, a da se ne koristi od strane ugrađenog
kompajlera.

Postoji nekoliko metoda koji mogu ovo popraviti, izlistane su od
najjednostavnijih do složenijih.

- otvoriti `project->properties->java build path->libraries` i tu
eksplicitno dodati odgovarajući jar. Ovaj metod naravno radi samo
za pojedinačan projekat.

- slično se u istom meniju može ukloniti JRE koji je već prisutan
("remove") i potom odabrati opcije "Add library"->"Add system JRE", te
ponovo odaberati odgovarajući JRE. Ovo je isto na nivou projekta, ali
može osvežiti i glavni spisak biblioteka.

- otvoriti `Winow->preferences->java->installed JREs` naći trenutni
problematično prepoznati JRE, zapamtiti njegovu lokaciju, obrisati ga
sa spiska, a nakon toga ga ponovo dodati sa "search" koristeći
prethodno zapamćenu lokaciju. Ovo bi trebalo da sigurno osveži sve
bibilotetke vezane za konkretni JRE.

## Testiranje instalacije

Za jednostavno testiranje da li je bibloteka ispravno instalirana i da
li se ispravno vidi od strane java kompajlera, napravljen je glavni
metod u klasi `Svetovid` koji ispisuje trenutnu instaliranu verziju.
Najjednostavnije se može izvršiti sledećim pozivom:

`java Svetovid`

Ako je jar dodat negde gde ga JVM vidi, biće ispisana poruka o verziji
Svetovid biblioteke, a ako nije ispisaće se greška da klasa nije
nađena.

Prilikom ispisa verzije biće urađena i provera da li postoji novija verzija
biblioteke i ako ona postoji korisnik će o tome biti obavešten.

Pokretanje `jar` fajla direktno iz nekog grafičkog okruženja (tipično
dupli klik u nekom upravljaču fajlovima) će otvoriti mali dijalog sa
ispisom verzije.

## Stara uputstva

### Dodavanje na sistemskom nivou u JVM (do verzije 8)

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

### Dodavanje u editor *DrJava*

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
