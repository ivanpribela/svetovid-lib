/**
 * U ovoj klasi ce biti demonstrirana dva pristupa za ispisivanje svih redova
 * jednog fajla na ekran. Prvi primer je direktan i cita fajl red po red, dokle
 * god ne dodje do kraja. Drugi koristi pogodnosti Svetovid biblioteke i
 * odjednom ucitava sve redove kao niz stringova, i odmah ih ispisuje na ekran
 * odgovarajucom komandom. Potencijalana mana ovog drugog pristupa je sto ce se
 * svi redovi odjednom naci u memoriji. Dodatna prednost kod prvog pristupa je
 * i to sto mozemo lako modifikovati kod tako da se usput odustane od daljeg
 * citanja fajla ako smo nasli ono sto smo trazili, ili ako smo nasli neku
 * gresku.
 */
public class CitanjeFajla {

    /** Cita i ispisuje sve redove fajla na ekran. */
    static void citajSveRedove(String imeFajla) {

        /* Radimo dokle god fajl nije prazan */
        while (!Svetovid.in(imeFajla).isEmpty()){

            /* Citamo ceo red */
            String red = Svetovid.in(imeFajla).readLine();

            /* Ispisujemo procitani red */
            Svetovid.out.println(red);

        }

    }

    /** alternativni nacin da ispisemo sve redove fajla. */
    static void citajSveRedoveAlt(String imeFajla) {

        /* Koriste se pogodnosti biblioteke za citanje svih redova odjednom */
        Svetovid.out.println(Svetovid.in(imeFajla).readAll());

    }

    /** Glavni program koji poziva prethodna dva metoda. */
    public static void main(String[] args) {

        // Pitamo korisnika za ime fajla koji korisitmo
        String imeFajla = Svetovid.in.readString("Unesite ime fajla:");

        // Poziv prvog nacina ispisivanja
        citajSveRedove(imeFajla);

        // Moramo zatvoriti fajl da bi ga opet citali ispocetka
        Svetovid.in(imeFajla).close();

        // Poziv drugog nacina ispisivanja
        citajSveRedoveAlt(imeFajla);

    }

}
