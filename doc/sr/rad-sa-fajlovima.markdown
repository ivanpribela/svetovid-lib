# Rad sa fajlovima

Čitanje iz fajla je jako slično čitanju sa standardnog ulaza -- jedino
je potrebno dodatno naglasiti iz kog fajla se čita, na primer:

`int i = Svetovid.in("fajl1.txt").readInt();`

Fajl će automatski biti otvoren ako nije bio ranije otvoren u okviru
programa, a ukoliko jeste onda će čitanje biti nastavljeno sa istog
mesta gde je prethodni put prestalo, odnosno biće učitan sledeći broj.

Slično važi i za pisanje u fajlove, na primer kratka poruka se lako
može ispisati u novi fajl:

`Svetovid.out("izlazni.txt").write("poruka");`

Ako je fajl već postojao, njegov sadržaj će biti zamenjen samo ovim
tekstom. Ukoliko želimo da dopišemo tekst na kraj fajla, to možemo
lako uraditi na sledeći način:

`Svetovid.append("izlazni.txt").write(" nastavak poruke");`

Alternativno se može koristiti dodatni parametar pri prosleđivanju
imena fajla, na primer recimo da želimo da ispišemo dva reda u novi
fajl:

```java
Svetovid.out("novi.txt", false).writeln("prvi red");
Svetovid.out("novi.txt", true).writeln("drugi red");
```
