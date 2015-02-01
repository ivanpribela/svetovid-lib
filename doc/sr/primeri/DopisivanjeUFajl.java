/** 
 * Ovaj primer prikazuje dopisivanje na kraj postojeceg fajla, koriscenje
 * opcije "append" umesto "out". Svaki put kad se program pokrene dopisace na
 * kraj fajla "novi.txt" po dva reda. Ako fajl nije postojao bice napravljen.
 */
public class DopisivanjeUFajl {

    public static void main(String[] args) {
        Svetovid.append("novi.txt").println("Dodatni red");
        Svetovid.append("novi.txt").println("Drugi dodatni red");
    }
}
