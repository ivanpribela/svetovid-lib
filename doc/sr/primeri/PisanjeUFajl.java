/** 
 * Ovaj primer demonstrira pisanje u novi fajl. Ako fajl ne postoji bice
 * napravljen, a ako fajl postoji bice zamenjen sa ovim sadrzajem. Na kraju
 * rada programa ce u fajlu sa imenom "novi.txt" biti upisana dva reda.
 */
public class PisanjeUFajl {

    public static void main(String[] args) {
        Svetovid.out.println("Pisanje dva reda u fajl");
        Svetovid.out("novi.txt").println("prvi red");
        Svetovid.out("novi.txt").println("drugi red");
    }
}
