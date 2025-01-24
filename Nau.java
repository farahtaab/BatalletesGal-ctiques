abstract class Nau {
    protected int fil;
    protected int col;
    protected char tipus;
    protected String bandol;

    public Nau(int fil, int col, char tipus, String bandol) {
        this.fil = fil;
        this.col = col;
        this.tipus = tipus;
        this.bandol = bandol;
    }

    public char getTipus() {
        return tipus;
    }

    /**
     * Comprova si una posició està dins del tauler.
     */
    public boolean estaDins(int fila, int columna) {
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }

    /**
     * Comprova si es pot moure a una posició:
     * - Dins del tauler.
     * - Casella buida o enemiga.
     * - No permet moure's a una casella del mateix bàndol.
     */
    public boolean esPotMoure(int fila, int columna, char[][] matriu) {
        if (!estaDins(fila, columna)) {
            return false; // Fora del tauler
        }

        char nauDest = matriu[fila][columna];

        if (nauDest == '.') {
            return true; // Casella buida
        }

        // Comprovar si és enemiga
        boolean esEnemic = Character.isUpperCase(tipus) != Character.isUpperCase(nauDest);
        return esEnemic; // Es pot moure només si és enemic
    }

    /**
     * Comprova si el moviment implica atacar un enemic.
     */
    public boolean estemAtacant(int fila, int columna, char[][] matriu) {
        if (!estaDins(fila, columna)) {
            return false; // Fora del tauler
        }

        char nauDest = matriu[fila][columna];
        return nauDest != '.' && Character.isUpperCase(tipus) != Character.isUpperCase(nauDest);
    }

    /**
     * Cada nau implementa la seva pròpia lògica de moviment.
     */
    public abstract boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu);
}
