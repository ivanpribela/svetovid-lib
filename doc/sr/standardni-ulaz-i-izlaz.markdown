# Učitavanje i ispisivanje sa standardnog ulaza i izlaza

Učitavanje osnovnih tipova u konzolnoj aplikaciji se sa standardnom
ulaza može jednostavno postići metodima u `Svetovid.in`:

`int i = Svetovid.in.readInt();`

Metodu se može proslediti i string koji će predstavljati upit
korisniku, na primer:

`int i = Svetovid.in.readInt("unesite broj: ");`

Ispis osnovnih tipova na ekran je relativno jednostavan u okviru
jezika Java, ali je kompletnosti i uniformnosti radi dodata i ova
funkcionalnost u okviru biblioteke Svetovid.

`Svetovid.out.write(a);`
`Svetovid.out.writeln(a);`

Pri čemu `a` može biti bilo koji od osnovnih tipova. Analogne komande
se mogu naći u okviru klase `System`, a mogu se koristiti bez problema
naizmenično sa onima iz klase `Svetovid`: 

`System.out.println(a)`