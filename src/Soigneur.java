public class Soigneur extends Emloye {

    public Soigneur(String nom, String prenom, double salaire) {
        super(nom, prenom, salaire);

    }

    @Override
    public String effectuerTache(Animal animal) {
        return animal.soinQuotidien();
    }

    @Override
    public String getRole() {
        return "Soigneur";
    }

}
