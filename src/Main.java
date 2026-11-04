import java.util.ArrayList; // Import the ArrayList class

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Emloye> employes = new ArrayList<>();
        Soigneur Employe1 = new Soigneur("Albert", "Dupont", 3500);
        Soigneur Employe2 = new Soigneur("Laure", "Dinateur", 4000);
        Soigneur Employe3 = new Soigneur("Jean", "naimar", 3500);
        Veterinaire Employe4 = new Veterinaire("Albert", "Cavu", 5000);
        Soigneur Employe5 = new Soigneur("Brigitte", "c++", 4500);
        Veterinaire Employe6 = new Veterinaire("Chu", "Ki", 3500);
        ConsoleIO io = new ConsoleIO();

        employes.add(Employe1);
        employes.add(Employe2);
        employes.add(Employe3);
        employes.add(Employe4);
        employes.add(Employe5);
        employes.add(Employe6);

        listerEmployer(employes, io);

        /*boolean estRepete = true;
        do {
            if (gestionAnimal(animals, io)) {
                estRepete = false;
            }
        } while (estRepete);*/
    }

    private static void ajouterAnimal(ArrayList<Animal> animals, ConsoleIO io) {
        String[] donnees = new String[4];
        String type;
        String nom;
        int age = 0;
        int indexSante = 0;
        Animal animal = null;
        boolean typeInconnu = false;
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
                typeInconnu = true;
                break;
        }
    } while (typeInconnu);
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
            io.afficher("Il n'y a aucun animal à lister.");
            return;
        }
        for (int i = 0; i < animals.size(); i++) {
            io.afficher((i + 1) + ". " + animals.get(i));
        }
    }

   private static boolean gestionAnimal(ArrayList<Animal> animals, ConsoleIO io) {
       io.afficher("Que voulez vous faire ?\n\n" +
               "1. Ajouter un animal.\n" +
               "2. Supprimer un animal.\n" +
               "3. Lister les animaux.\n" +
               "4. Quitter.\n");

       String actionChoisi;
       actionChoisi = io.lireLigne();
       int parts = Integer.parseInt(actionChoisi.trim());

       switch (parts) {
           case 1:
               ajouterAnimal(animals, io);
               break;
           case 2:
               supprimerAnimal(animals, io);
               break;
           case 3:
               listerAnimaux(animals, io);
               break;
           case 4:
               io.afficher("Au revoir !");
               return true;
           default:
               io.afficher("Choix invalide, entre 1, 2, 3 ou 4.");
               return false;
       }
       return true;
   }

   private static boolean gesionEmployer(ArrayList<Animal> animals, ArrayList<Emloye> employes, ConsoleIO io) {
       io.afficher("Quel employer utiliserer vous ?\n\n");
       listerEmployer(employes, io);
       String employeChoisi;
       employeChoisi = io.lireLigne();
       int parts = Integer.parseInt(employeChoisi.trim());
       employes.get(parts);

/*
       switch (parts) {
           case 1:
               ajouterAnimal(animals, io);
               break;
           case 2:
               supprimerAnimal(animals, io);
               break;
           case 3:
               listerAnimaux(animals, io);
               break;
           case 4:
               io.afficher("Au revoir !");
               return true;
           default:
               io.afficher("Choix invalide, entre 1, 2, 3 ou 4.");
               return false;
       }*/
       return true;
   }

    private static void listerEmployer(ArrayList<Emloye> employes, ConsoleIO io) {
        if (employes.isEmpty()) {
            io.afficher("Il n'y a aucun animal à lister.");
            return;
        }
        for (int i = 0; i < employes.size(); i++) io.afficher((i + 1) + ". " + employes.get(i).getNom();
    }
}
