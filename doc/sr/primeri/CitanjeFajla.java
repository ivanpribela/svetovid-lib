/** U ovoj klasi ce biti demonstrirana dva pristupa za ispisivanje
svih redova na ekran. Prvi je direktan i cita fajl red po red, dokle
god ne dodje do kraja. Drugi koristi pogodnosti biblioteke Svetovid i
ucita odjednom sve redove kao niz Stringova, te ih odmah i ispise na
ekran odgovarajucom komandom. Potencijalana mana ovog drugog pristupa
je sto ce se svi redovi odjednom naci u memoriji. Dodatna prednost kod
prvog pristupa je i sto mozemo lako modifikovati kod tako da se usput
odustane od daljeg citanja fajla ako smo nasli ono sto smo trazili,
ili nasli neku gresku. */
public class CitanjeFajla{

    /** cita i ispisuje sve redove fajla na ekran */
    static void citajSveRedove(String imeFajla){
	/* radimo dokle god fajl nije prazan */
	while (!Svetovid.in(imeFajla).isEmpty()){
	    String red = Svetovid.in(imeFajla).readLine();
	    Svetovid.out.writeln(red);
	}	
    }

    /** alternativni nacin da ispisemo sve redove fajla */
    static void citajSveRedoveAlt(String imeFajla){
	/* Koriste se pogodnosti biblioteke za citanje svih redova
	 odjednom.  */
	Svetovid.out.writeln(Svetovid.in(imeFajla).readAll());
    }

    public static void main(String[] args){
	Svetovid.out.writeln("unesite ime fajla:");
	String imeFajla = Svetovid.in.readString();

	citajSveRedove(imeFajla);

	/* moramo zatvoriti fajl da bi ga opet citali ispocetka */
	Svetovid.in(imeFajla).close();

	citajSveRedoveAlt(imeFajla);
    }
}