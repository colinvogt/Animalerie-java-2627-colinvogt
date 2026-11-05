public enum EtatSante {
    SAIN("Sain"),
    SOIN_LEGER("Soin leger"),
    SOIN_INTENSIF("Soin intensif");

    private String etatSante;

    EtatSante(String etatSante) {
        this.etatSante = etatSante;
    }

    public EtatSante ameliorer() {
        if (this == SAIN) {
            return this; // déjà au mieux, on évite l'index -1
        }
        return values()[ordinal() - 1];
    }

    public String toString() {
        return etatSante;
    }
}

