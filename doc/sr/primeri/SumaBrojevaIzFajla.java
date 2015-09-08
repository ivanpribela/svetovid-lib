/**
 * Ovo je primer citanja brojeva iz fajla i njihovog sumiranja. Brojevi u fajlu
 * mogu biti rasporedjeni bilo kako, bitno je samo da su razdvojeni prelomima
 * redova, razmacima ili tabulatorima. Mogu postojati i prazni redovi,
 * visestruki razmaci ili bilo kakve kombinacije separatora, program ce raditi
 * kako treba. Jedino je bitno da su u fajlu sve brojevi.
 *
 * Videti primer u datom fajlu 'brojevi.txt'.
 */
public class SumaBrojevaIzFajla {

    /** Ime fajla iz kojeg citamo brojeve. */
    public static final String IME_FAJLA = "brojevi.txt";

    /** Glavni program. */
    public static void main(String[] args) {

        // Ispisujemo prigodnu poruku
        Svetovid.out.println("Ucitavamo brojeve iz fajla " + IME_FAJLA);

        // Suma je na pocetku nula
        double suma = 0;

        // Ucitamo prvi broj
        Double broj = Svetovid.in(IME_FAJLA).readDoubleBoxed();

        // Ako je broj uspesno ucitan
        while (broj != null) {

            // Dodajemo ga na sumu
            suma = suma + broj;

            // I citamo novi broj
            broj = Svetovid.in(IME_FAJLA).readDoubleBoxed();

        }

        // Ispisemo ukupnu sumu na ekran
        Svetovid.out.println(suma);

    }

}
