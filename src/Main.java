import java.util.ArrayList; // Import the ArrayList class
import java.util.Arrays;

public class Main {
    static final String regex = "[,\\.\\s]";

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        ConsoleIO io = new ConsoleIO();
        boolean estRepete = true;

        do {
            io.afficher("Que voulez vous faire ?\n\n" +
                    "1. Ajouter un animal.\n" +
                    "2. Supprimer un animal.\n" +
                    "3. Lister les animaux.\n");

            String actionChoisi;
            actionChoisi = io.lireLigne();
            int parts = Integer.parseInt(actionChoisi.trim());

            switch (parts) {
                case 1:
                    io.afficher("Type(Chien Chat, Lapin), Nom, Age, Santé(0-2 / 0 = Sain, 2 = Soin intensif)");
                    String donneeAnimal;
                    donneeAnimal = io.lireLigne();
                    String[] donnees = donneeAnimal.trim().split(regex);

                    animals = new

            }


        } while (estRepete);
    }

    private static void ajouterAnimal(ArrayList<Animal> animals, ConsoleIO io) {
        String[] donnees = new String[4];
        String type;
        String nom;
        int age = 0;
        int indexSante = 0;
        do {
            do {
                donnees = null;
                io.afficher("Type, Nom, Age, Santé\n" +
                        "Type : chien ou chat\n" +
                        "Santé : 0 = Sain, 1 = Soin léger, 2 = Soin intensif\n" +
                        "Exemple : chien, Rex, 5, 1");

                donnees = io.lireLigne().trim().split("\\s*,\\s*");

                if (donnees.length != 4) {
                    io.afficher("Il faut 4 valeurs séparées par des virgules.");
                }
            } while (donnees.length != 4);

            type = donnees[0].toLowerCase();
            nom = donnees[1];
            age = Integer.parseInt(donnees[2]);
            indexSante = Integer.parseInt(donnees[3]);

            if (indexSante < 0 || indexSante >= EtatSante.values().length) {
                io.afficher("La santé doit être entre 0 et 2.");
            }
        } while (indexSante < 0 || indexSante >= EtatSante.values().length);
        EtatSante sante = EtatSante.values()[indexSante];

        Animal animal;
        switch (type) {
            case "chien":
                animal = new Chien(nom, age, sante);
                break;
            case "chat":
                animal = new Chat(nom, age, sante);
                break;

        }
    }


}
