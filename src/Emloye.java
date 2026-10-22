public abstract class Emloye {
    private String nom;
    private String prenom;
    private double salaire;
    private String role;

    public Emloye(String nom, String prenom, double salaire, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.role = role;
    }

    public abstract String effectuerTache(Animal animal);
}
