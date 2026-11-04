import java.util.ArrayList; // Import the ArrayList class

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Emloye> employes = new ArrayList<>();
        ConsoleIO io = new ConsoleIO();

        // Employes de depart pour tester les soins.
        employes.add(new Soigneur("Dupont", "Alice", 3500));
        employes.add(new Soigneur("Martin", "Lucas", 3800));
        employes.add(new Soigneur("Bernard", "Emma", 4000));

        employes.add(new Veterinaire("Durand", "Hugo", 5000));
        employes.add(new Veterinaire("Petit", "Lea", 5500));
        employes.add(new Veterinaire("Robert", "Nathan", 5200));
        
        // Animaux de depart pour tester les soins.
        animals.add(new Chien("Rex", 5, EtatSante.SAIN));
        animals.add(new Chien("Nala", 3, EtatSante.SOIN_LEGER));
        animals.add(new Chien("Max", 8, EtatSante.SOIN_INTENSIF));

        animals.add(new Chat("DestructeurDePlanete", 2, EtatSante.SAIN));
        animals.add(new Chat("DestructeurDeGalaxy", 6, EtatSante.SOIN_LEGER));
        animals.add(new Chat("Mouchoir", 4, EtatSante.SOIN_INTENSIF));

        animals.add(new Lapin("Noisette", 1, EtatSante.SAIN));
        animals.add(new Lapin("Pompon", 3, EtatSante.SOIN_LEGER));
        animals.add(new Lapin("Caramel", 2, EtatSante.SOIN_INTENSIF));



        String actionChoisi;
        boolean continuer = true;
        do {
            io.afficher("1. S'occuper d'un animal\n" +
                    "2. Ajouter/lister/supprimer un animal\n" +
                    "4. Ajouter/lister/supprimer un employer\n" +
                    "3. Quitter");
            actionChoisi = io.lireLigne();
            int parts = Integer.parseInt(actionChoisi.trim());
            switch (parts) {
                case 1:
                    actionEmployer(animals, employes, io);
                    break;
                case 2:
                    boolean estRepete = true;
                    do {
                        if (gestionAnimal(animals, io)) {
                            estRepete = false;
                        }
                    } while (estRepete);
                    break;
                case 3: ge
                case 4:
                    io.afficher("Au revoir!");
                    continuer = false;
            }
        } while (continuer);

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
                    io.afficher("Type, Nom, Age, Santé\n\n" +
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
                "4. Retour.\n");

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
                return true;
            default:
                io.afficher("Choix invalide, entre 1, 2, 3 ou 4.");
                return false;
        }
        return false;
    }

    private static void actionEmployer(ArrayList<Animal> animals, ArrayList<Emloye> employes, ConsoleIO io) {
        io.afficher("Quel employer utiliserer vous ?\n\n");
        listerEmployer(employes, io);
        String employeChoisi;
        employeChoisi = io.lireLigne();
        int parts = Integer.parseInt(employeChoisi.trim());
        Emloye employeSelectionne = employes.get(parts - 1);

        io.afficher("De quelle animal voulez-vous vous occuper ?\n");
        listerAnimaux(animals, io);
        String animalChoisi;
        animalChoisi = io.lireLigne();
        int indice = Integer.parseInt(animalChoisi.trim());
        Animal animalSelectionne = animals.get(indice - 1);

        io.afficher(employeSelectionne.effectuerTache(animalSelectionne));
    }

    private static boolean gestionEmployer(ArrayList<Emloye> employes, ConsoleIO io) {
        io.afficher("Que voulez vous faire ?\n\n" +
                "1. Ajouter un employe.\n" +
                "2. Supprimer un employe.\n" +
                "3. Lister les employe.\n" +
                "4. Retour.\n");

        String actionChoisi;
        actionChoisi = io.lireLigne();
        int parts = Integer.parseInt(actionChoisi.trim());

        switch (parts) {
            case 1:
                ajouterEmployer(employes, io);
                break;
            case 2:
                supprimerEmployer(employes, io);
                break;
            case 3:
                listerEmployer(employes, io);
                break;
            case 4:
                return true;
            default:
                io.afficher("Choix invalide, entre 1, 2, 3 ou 4.");
                return false;
        }
        return false;
    }

    private static void listerEmployer(ArrayList<Emloye> employes, ConsoleIO io) {
        if (employes.isEmpty()) {
            io.afficher("Il n'y a aucun animal à lister.");
            return;
        }
        for (int i = 0; i < employes.size(); i++) {
            io.afficher((i + 1) + ". " + employes.get(i).getAll());
        }
    }

    private static void ajouterEmployer(ArrayList<Emloye> employes, ConsoleIO io) {
        String[] donnees = new String[4];
        String prenom;
        String nom;
        String role;
        int salaire = 0;
        Veterinaire veterinaire = null;
        Soigneur soigneur = null;
        boolean typeInconnu = false;
        do {
            do {
                do {
                    donnees = null;
                    io.afficher("Nom, Prenom, role, Salaire\n\n" +
                            "Role : Soigneur/Veterinaire\n" +
                            "Exemple : Dupont, Alice, Veterinaire, 5000");

                    donnees = io.lireLigne().trim().split("\\s*,\\s*");

                    if (donnees.length != 4) {
                        io.afficher("Il faut 4 valeurs séparées par des virgules.");
                    }
                } while (donnees.length != 4);

                nom = donnees[0];
                prenom = donnees[1];
                role = donnees[2].toLowerCase();
                salaire = Integer.parseInt(donnees[3]);

                if (salaire < 0 ) {
                    io.afficher("Le salaire doit etre positif");
                }
            } while (salaire < 0);

            switch (role) {
                case "veterinaire":
                    veterinaire = new Veterinaire(nom, prenom, salaire);
                    break;
                case "soigneur":
                    soigneur = new Soigneur(nom, prenom, salaire);
                    break;
                default:
                    io.afficher("Role inconnu : " + role);
                    typeInconnu = true;
                    break;
            }
        } while (typeInconnu);
        if (veterinaire != null) {
            employes.add(veterinaire);
        } else {
            employes.add(soigneur);
        }
        String ligne = String.format("%s %s a été ajouter", nom, prenom);
        io.afficher(ligne);
    }
}
