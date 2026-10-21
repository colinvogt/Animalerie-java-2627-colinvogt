public class Lapin extends Animal {

    public Lapin(String nom, int age, EtatSante sante) {
        super(nom, age, sante);
    }

    @Override
    public String bruit() {
        return "...";
    }

    @Override
    public String soinQuotidien() {
        return "dormir";
    }

}
