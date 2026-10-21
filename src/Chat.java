public class Chat extends Animal {

    public Chat(String nom, int age, EtatSante sante) {
        super(nom, age, sante);
    }

    public String bruit() {
        return "Miaou";
    }

    public String soinQuotidien() {
        return "dormir";
    }
}
