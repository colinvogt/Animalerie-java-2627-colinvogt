import java.util.Scanner;

public class ConsoleIO{
    private final Scanner myObj;

    /**
     * Constructeur ConsoleIO
     */
    ConsoleIO() {
        this.myObj = new Scanner(System.in);
    }

    /**
     * Affiche le prompte mis en parametre
     * @param prompt
     */
    public void afficher(String prompt) {
        System.out.println(prompt);
    }

    /**
     * Lit le prompt inserer par l'utilisateur
     * @return
     */
    public String lireLigne() {
        return myObj.nextLine();
    }
}