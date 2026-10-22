public class Veterinaire extends Emloye {

    public Veterinaire(String nom, String prenom, double salaire, String role) {
        super(nom, prenom, salaire, role);
    }

    @Override
    public String effectuerTache(Animal animal) {
        if (animal.getSante() == EtatSante.SAIN) {
            return "L'animal est déjà en bonne santé";
        }
        animal.setSante(animal.getSante().ameliorer());
        return  "l'animal c'est fait soigné il est maintenant " + animal.getSante();
    }
}
