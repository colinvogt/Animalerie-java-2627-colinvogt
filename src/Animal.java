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

    public EtatSante getSante() {
        return sante;
    }

    public int getAge() {
        return age;
    }

    public abstract String bruit();

    public abstract String soinQuotidien();

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSante(EtatSante sante) {
        this.sante = sante;
    }

    @Override
    public String toString() {
        return nom + ", " + age + " ans, " + sante;
    }
}
