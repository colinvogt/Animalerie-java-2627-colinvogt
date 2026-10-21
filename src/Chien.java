public class Chien extends Animal {

    public Chien(String nom, int age, EtatSante sante) {
        super(nom, age, sante);
    }

    public String bruit() {
        return "Wouaf!";
    }

    public String soinQuotidien() {
        return "brosser";
    }
}
