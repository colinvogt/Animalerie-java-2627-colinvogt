public enum EtatSante {
    SAIN,
    SOIN_LEGER,
    SOIN_INTENSIF;

    public EtatSante ameliorer() {
        if (this == SAIN) {
            return this; // déjà au mieux, on évite l'index -1
        }
        return values()[ordinal() - 1];
    }
}

