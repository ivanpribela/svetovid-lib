/** 
 * Ovaj primer demonstrira pisanje u novi fajl. Ako fajl ne postoji
 * bice napravljen, a ako fajl postoji bice zamenjen sa ovim sadrzajem.
 * Na kraju rada programa ce u fajlu sa imenom "novi.txt" biti upisana
 * dva reda.
 */
public class PisanjeUFajl {

    public static void main(String[] args) {
	Svetovid.out.writeln("Pisanje dva reda u fajl");
	Svetovid.out("novi.txt").writeln("prvi red");
	Svetovid.out("novi.txt").writeln("drugi red");
    }
}