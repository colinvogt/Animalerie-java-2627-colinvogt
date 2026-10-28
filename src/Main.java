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
                    ajouterAnimal(animals, io);
                    break;

            }


        } while (estRepete);
    }

    private static void ajouterAnimal(ArrayList<Animal> animals, ConsoleIO io) {
        String[] donnees = new String[4];
        String type;
        String nom;
        int age = 0;
        int indexSante = 0;
        Animal animal = null;
        boolean typeConnu = true;
        do {
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


        switch (type) {
            case "chien":
                animal = new Chien(nom, age, sante);
                break;
            case "chat":
                animal = new Chat(nom, age, sante);
                break;
            case "lapin":
                animal = new Lapin(nom, age, sante);
                break;
            default:
                io.afficher("Type inconnu : " + type);
                typeConnu = false;
                break;
        }
    } while (typeConnu);
        animals.add(animal);
        io.afficher(nom + " a été ajouté.");
    }

    private static void supprimerAnimal(ArrayList<Animal> animals, ConsoleIO io) {
        if (animals.isEmpty()) {
            io.afficher("Il n'y a aucun animal à supprimer.");
            return;
        }

        listerAnimaux(animals, io);
        io.afficher("Numéro de l'animal à supprimer :");

        int numero = 0;
        do {
            numero = Integer.parseInt(io.lireLigne().trim());
            if (numero < 1 || numero > animals.size()) {

                io.afficher("Numero Invalide");
            }
        } while ((numero < 1 || numero > animals.size()));

        Animal supprime = animals.remove(numero - 1);
        io.afficher(supprime.getNom() + " a été supprimé.");
    }

    private static void listerAnimaux(ArrayList<Animal> animals, ConsoleIO io) {
        if (animals.isEmpty()) {
            io.afficher("Il n'y a aucun animal à supprimer.");
            return;
        }
        for (int i = 0; i < animals.size(); i++) {
            io.afficher((i + 1) + ". " + animals.get(i));
        }
    }
}
