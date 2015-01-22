/**
   Primer citanja brojeva iz fajla i njihovog sumiranja. Brojevi u fajlu
   mogu biti rasporedjeni bilo kako, bitno je samo da su razdvojeni 
   prelomima redova, razmacima ili tabulatorima. Mogu postojati i prazni
   redovi, visestruki razmaci ili bilo kakve kombinacije separatora, program
   ce raditi kako treba. Jedino je bitno da su u fajlu sve brojevi.

   Videti primer u datom fajlu 'brojevi.txt'.
 */
public class SumaBrojevaIzFajla {
    public static void main(String[] args) {
	Svetovid.out.writeln("Ucitavamo brojeve iz fajla 'brojevi.txt'");
	int suma = 0;
	while (!Svetovid.in("brojevi.txt").isEmpty()) {
	    int broj = Svetovid.in("brojevi.txt").readInt();
	    suma = suma + broj;
	}
	Svetovid.out.writeln(suma);
    }
}