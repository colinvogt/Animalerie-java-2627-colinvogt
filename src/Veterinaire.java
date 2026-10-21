public class Veterinaire extends Emloye {

    public Veterinaire(String nom, String prenom, double salaire, String role) {
        super(nom, prenom, salaire, role);
    }

    @Override
    public String effectuerTache(Animal animal) {
        return "soigne un animal malade et améliore son état de santé.";
    }

}