import java.util.ArrayList;

public class Concours {
    private String nom;
    private String lieu;
    private int capacite;
    private int participants;
    private final ConsoleIO io;

    public Concours(ConsoleIO io, int participants, int capacite, String lieu, String nom) {
        this.io = io;
        this.participants = participants;
        this.capacite = capacite;
        this.lieu = lieu;
        this.nom = nom;
    }
}
