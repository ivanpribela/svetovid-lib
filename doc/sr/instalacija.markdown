# Instalacija Svetovid-lib biblioteke


Budući da biblioteka nije deo standardne Java Virtualne Mašine,
neophodno je nekako uputiti kompajler da je koristi. Ovo se može
uraditi na više načina. Ako već znate kako da dodajete bilbioteke
možete to iskoristiti i ovde.

Ovde će biti dato nekoliko najverovatnijih scenarija koje korisnici
imaju, pa na osnovu toga treba da odaberu šta će raditi.

- [Instalacija na sistemskom nivou, vezivanje direktno za JDK.](#instalacija-na-nivou-sistema)
  - Preporučuje se korisnicima koji su administratori (glavni
  korisnici) svojih mašina i koristiće Svetovid-lib u programima na
  razne načine na računaru.
  - Ovo omogućava korišćenje iz komandne
  linije, kao i bilo kakvog editora koji direktno poziva Java
  kompajler (kao što su Geany, Gedit, Kate, Emacs, Vim, ...)
  - Dat je i jednostavan način za testiranje da li je biblioteka
    adekvatno instalirana.


- [Dodavanje biblioteke u pojedinačne pozive kompajliranja i pokretanja](#direktno-dodavanje-biblioteke-u-pojedinačnim-pozivima)
  - Preporučuje se za korisnike koji iz bilo kog razloga ne mogu ili
  ne žele da dodaju biblioteku na ceo sistem
  - Dato je nekoliko načina da se ovo postigne, uključujući
  rad iz komandne linije, kao i pristup za editor Geany

- [Dodavanje biblioteke u Eclipse ili neko drugo razvojno okruženje](#dodavanje-u-razvojna-okruženja)
  - Eclipse (ali i mnogi drugi) ignorišu neka od sistemskih podešavanja
  - Tipično je neophodno da se u svaki projekat doda biblioteka,
  nezavisno od toga da li je dodata na sistemskom nivou


**Napomena:** U okviru ovih uputstava podrazumevamo da je već na sistemu instalirano
Java razvojno okruženje (JDK), i da je odgovarajuće postavljena
promenljiva `PATH` nas sistemu, tako da je moguće samo otvoriti
komandnu liniju i ukucati `java -version` i `javac -version` i dobiti
podatke o tome koja je verzija kompajlera i izvršnog okruženja
instalirana na sistemu.

Uputstva su uglavnom dosta opšte prirode uz neke specifične napomene
za Linux i Windows sisteme. Korisnici Mac OS operativnog sistema
uglavnom treba da se drže preporuka za Linux koje se tiču oblika
komandi, ali budući da nismo detaljno testirali na tom sistemu,
preporučujemo proveru kako se odgovarajuća podešavanja vrše tamo.

## Instalacija na nivou sistema

### Korišćenje skriptova za instalaciju

Na sajtu se može naći arhiva u kojoj se nalaze skriptovi koji služe za
instaliranje na nekim operativnim sistemima zajedno sa samom
bibliotekom u `jar` fajlu. Oni će instalirati biblioteku tako da se
može koristiti bilo gde na sistemu, i trebalo bi da samo radi u većini
alata koji služe za pisanje Java programa.

U opštem slučaju, ovi skriptovi se mogu pokrenuti iz komandne linije
uz administratorska prava, a moguće je da će raditi i ako se duplo
klikne na njih. Preporučujemo korisnicima da potraže uputstva kako se
najbolje pokreću skriptovi pod njihovim konkretnim operativnim
sistemom ako uputstva niže nisu dovoljna.

Pod Linux sistemima, to će obično značiti da se otvori konzola u
folderu gde je raspakovan zip (iz upravljača fajlovima ako postoji
opcija, ili otvoriti konzolu i koristiti komandu `cd` do odgovarajućeg
foldera) i pokrenuti `sudo ./install-svetovid-lib.sh`.

Pod Windows sistemima se tipično mora otvoriti administratorska
komandna linija i onda otići u odgovarajući folder komandama `cd`, te
izvršiti `install-svetovid-lib.bat`.

Za Mac OS nije dat skript za instalaciju, budući da nismo mogli
testirati na takvim mašinama. Preporučujemo da korisnici pogledaju
niže šta treba da podese i nađu uputstva kako se to inače radi na ovom
sistemu i nameste za ovu konkretnu biblioteku. Koliko smo upoznati,
skript za Linux *neće* raditi pod ovim sistemom.

Zainteresovani za detalje kako ovo funkcioniše mogu potražiti niže
objašnjenja koja se tiču `CLASSPATH`-a.

Neki od kompleksnijih alata, kao što je Eclipse, koji insistiraju na
korišćenju projekata za pisanje programa često ne koriste sistemska
podešavanja već su neophodna ručna doterivanja. Za to preporučujemo da
pogledate sekcije niže.

### Dodavanje u `CLASSPATH`

Java koristi sistemsku promenljivu `CLASSPATH` da nalazi sve
biblioteke.  Ona se može promeniti za trenutnog korisnika, ili za sve
korisnike. Ukoliko se u ovaj spisak doda putanja do "jar" fajla, tada
će svi pozivi i za kompajliranje i za pokretanje Java programa
koristiti ovu biblioteku kad je potrebno. U suštini je ekvivaletno sa
niže pomenutim metodom koji koristi `-cp` parametar, odnosno efekat je
kao da se uvek navodi i ova biblioteka.

Ova opcija je jako dobra jer nije neophodno pojedinačno nameštanje
različitih editora da koriste biblioteku.

U okviru zipa koji se može skinuti sa sajta su stavljeni skriptovi
za upravo ovakvu instalaciju, pa se preporučuje njihova upotreba.

Naravno, napredni korisnici možda žele da još prilagode kako se
skriptovi ponašanju.

Ako ne možete ili ne želite da koristite skriptove, preporučujemo
traženje adekvatnih uputstava za korisnikov operativni sistem za
detalje kako se biblioteke dodaju u `CLASSPATH` i primeniti to na
konkretan slučaj ove biblioteke.

Takođe, u slučaju ručnog dodavanja preporučujemo da se biblioteka drži
na nekom stalnom i logičnom mestu, na primer direktno u korenu
korisničkog foldera, ili u nekom podfolderu tipa `lib`.


### Testiranje instalacije

Za jednostavno testiranje da li je bibloteka ispravno instalirana i da
li se ispravno vidi od strane java kompajlera, napravljen je glavni
metod u klasi `Svetovid` koji ispisuje trenutnu instaliranu verziju.
Najjednostavnije se može izvršiti sledećim pozivom iz komandne linije:

`java Svetovid`

Ako je jar dodat negde gde ga JVM vidi, biće ispisana poruka o verziji
Svetovid biblioteke, a ako nije ispisaće se greška da klasa nije
nađena.

Prilikom ispisa verzije biće urađena i provera da li postoji novija verzija
biblioteke i ako ona postoji korisnik će o tome biti obavešten.

Pokretanje `jar` fajla direktno iz nekog grafičkog okruženja (tipično
dupli klik u nekom upravljaču fajlovima) će otvoriti mali dijalog sa
ispisom verzije.


## Direktno dodavanje biblioteke u pojedinačnim pozivima

### Eksplicitno navodjenje jar-a pri kompajliranju

Najjednostavniji način da se omogući korišćenje biblioteke je staviti
odgovarajući "jar" fajl u radni direktorijum i pri kompajliranju ga
dodati u putanju klasa.

Pod Linuxom i drugim srodnim sistemima se to radi na sledeći način:

`javac -cp .:svetovid-lib.jar Program.java`

Slično je potrebno navoditi jar i pri pokretanju programa:

`java -cp .:svetovid-lib.jar Program`

Bitno je koristiti i "." za trenutni direktorijum za mnoge slučajeve. Simbol ":"
služi za razdvajanje delova putanje i može se koristi proizvoljan
broj puta ako hoćemo da dodajemo još biblioteka iza.

Ako se koristi Windows operativni sistem onda je jedina razlika
da se koristi ";" umesto ":" kod razdvajanja delova putanje:

`javac -cp .;svetovid-lib.jar Program.java`

`java -cp .;svetovid-lib.jar Program`



### Otpakivanje u trenutni direktorijum

Još jedan jednostavan način da se omogući korišćenje biblioteke u jednom
direktorijumu je da se otpakuju svi njeni fajlovi u taj direktorijum.
Ovo je nešto što je uvek moguće ukoliko imamo prava pisanja u tom
direktorijumu, a i kompajliranje se tada obavlja na isti način kao i uvek.

Mana ovog pristupa je što se "zagađuje" radno okruženje izvornim
fajlovima koji nisu striktno deo trenutnog programa, ali je za neka
brza isprobavanja funkcionalno rešenje.


### Podešavanje editora *Geany*

Editor Geany ima podršku za kompajliranje Java fajlova koja je aktivna
čim se otvori neki fajl sa `.java` ekstenzijom. Podrazumevano se
koristi već instalirana Java, tj alati `java` i `javac`.

*Preporučujemo da se biblioteka instalira na sistemskom nivou ako
je moguće, i tada nije potrebno menjati ništa od opcija izlistanih niže.*

Ukoliko u njima već nekako nije podešeno da se koristi biblioteka (npr
preko `CLASSPATH`), moguće je modifikovati pozive da koriste `-cp`
parametar (što je već opisano par sekcija iznad).

Promene se mogu uraditi na nekoliko načina.

#### Promene kroz vizuelne dijaloge

Ako je trenutno otvoren Java fajl, onda se podešavanja za
kompajliranje i pokretanje mogu otvoriti preko `Build->Set Build
Commands`. Dijalog se menja u zavisnosti od toga sa kakvim sadržajem
se radi. Nije bitno kakav Java fajl je otvoren, bitno je da bude bilo
šta sa odgovarajućom ekstenzijom. Alternativno se može promeniti
kako Geany tretira trenutni fajl preko `Document` menija.

Jednom kad je otvoren dijalog sa odgovarajućim opcijama, potrebno je
da se i `javac` ("Compile") i `java` ("Execute") preprave da koriste biblioteku. 
Opcija `-cp` je objašnjena iznad, dodaje stvari na `CLASSPATH`.

Na primer, ako smo pod Linux-om i bibloteka je u korisničkom "home"
folderu (tipično `/home/korisnik/`), prepraviti komande ovako nekako:

```
javac -cp .:$HOME/svetovid-lib.jar "%f"

java -cp .:$HOME/svetovid-lib.jar "%e"
```

Pod Windows-om je razlika u tome što se koriste ";" umesto ":" i drugačije
se naziva "kućni" direktorijum. Obratiti pažnju na to da li je stvarno
u tom folderu biblioteka. Ovo se može testirati otvaranjem upravljača
fajlovima i kucanjem `%HOMEPATH%`, što bi trebalo da otvori odgovarajući
folder, tipično `C:\Users\korisnik\`.

```
javac -cp .;%HOMEPATH%/svetovid-lib.jar "%f"

java -cp .;%HOMEPATH%/svetovid-lib.jar "%e"
```


#### Direktno menjanje konfiguracionih fajlova

Moguće je menjati direktno i konfiguracione fajlove za Geany koji su vezani za
jezike, to se u stvari u pozadini i dešava kad menjamo u dijalogu podešavanja.

Za promene kako se radi sa Java fajlovima potrebno je otvoriti odgovarajući
konfiguracioni fajl:

- meni `Tools->Configuration Files->Filetype configuration->Programming Languages->filetypes.java`

Ovde se nalaze podešavanja vezana za jezik. Ako je korisnik radio neke promene,
biće mu date samo te promene, a inače će biti kopiran podrazumevani fajl koji
se sada može menjati po potrebi. 

Ovako izgleda odgovarajuća sekcija fajla sa promenama koje su opisivane
gore za Linux:

```
[build-menu]
EX_00_LB=_Execute
EX_00_CM=java -cp .:$HOME/svetovid-lib.jar "%e"
EX_00_WD=
FT_00_LB=_Compile
FT_00_CM=javac -cp .:$HOME/svetovid-lib.jar "%f"
FT_00_WD=
```

Ako promene nisu još urađene, ova sekcija ne postoji i može se dodati bukvalno ovako 
kako je napisana na sam kraj fajla i videće se u build meniju odgovarajuće promene.

Već i u prošloj sekciji je naglašeno da su podešavanja suptilno drugačija ako smo pod Windows-om.
Koristeći iste pretpostavke kao i iznad, da smo ostavili fajl u svom korisničkom
folderu (tipično `C:\Users\korisnik\`) onda komande treba da su ovako
nešto

```
[build-menu]
EX_00_LB=_Execute
EX_00_CM=java -cp .;%HOMEPATH%/svetovid-lib.jar "%e"
EX_00_WD=
FT_00_LB=_Compile
FT_00_CM=javac -cp .;%HOMEPATH%/svetovid-lib.jar "%f"
FT_00_WD=
```


## Dodavanje u razvojna okruženja

Razvojna okruženja često ignorišu neka od sistemskih podešavanja,
uglavnom sa ciljem da daju konzistentnije ponašanje projekata. To
uglavnom znači da iako ste možda namestili biblioteku na nivou
sistema, da se ona ne vidi u projektu u okruženju.

Niže su data objašnjenja za nameštanje okruženja *Eclipse*, ali slično
se nameštaju i mnoga druga, za šta preporučujemo konsultovanje
odgovarajuće dokumentacije za dodavanje biblioteka u projekte.

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

- otvoriti `Window->preferences->java->installed JREs` naći trenutni
problematično prepoznati JRE, zapamtiti njegovu lokaciju, obrisati ga
sa spiska, a nakon toga ga ponovo dodati sa "search" koristeći
prethodno zapamćenu lokaciju. Ovo bi trebalo da sigurno osveži sve
bibilotetke vezane za konkretni JRE.


## Stara uputstva

[Uputstva koja se ne mogu primeniti na najnovije instalacije](instalacija-staro.markdown)
