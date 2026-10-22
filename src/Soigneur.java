public class Soigneur extends Emloye {

    public Soigneur(String nom, String prenom, double salaire, String role) {
        super(nom, prenom, salaire, role);
    }

    @Override
    public String effectuerTache(Animal animal) {
        return animal.soinQuotidien();
    }

}
