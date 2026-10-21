public class Lapin extends Animal {

    public Lapin(String nom, int age, EtatSante sante) {
        super(nom, age, sante);
    }

    public String bruit() {
        return "...";
    }

    public String soinQuotidien() {
        return "dormir";
    }

}
