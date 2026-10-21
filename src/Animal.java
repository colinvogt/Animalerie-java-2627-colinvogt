public abstract class Animal {
    private String nom;
    private int age;
    private EtatSante sante;

    public Animal(String nom, int age, EtatSante sante) {
        this.nom = nom;
        this.age = age;
        this.sante = sante;
    }

    public String getNom() {
        return nom;
    }

}
