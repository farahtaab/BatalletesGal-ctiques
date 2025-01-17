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

    public boolean estaDins(int fila, int columna) {
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }

    public boolean posicioOcupada(int fila, int columna, char[][] matriu) {
        return matriu[fila][columna] != '.'; // Casella no buida
    }

    public boolean potAtacar(int fila, int columna, char[][] matriu) {
        // Comprovar si la casella està dins del tauler
        if (!estaDins(fila, columna)) {
            return true; // Casella fora del tauler, no es pot atacar
        }

        char nauDest = matriu[fila][columna];

        // Comprovar si la casella està buida
        if (nauDest == '.') {
            return true; // Casella buida, no hi ha res a atacar
        }

        // Comprovar si és una peça del mateix bàndol
        boolean esMateixBandol = Character.isUpperCase(tipus) == Character.isUpperCase(nauDest);
        if (esMateixBandol) {
            return true; // No es pot atacar una peça del mateix bàndol
        }

        // Si no és del mateix bàndol i no està buida, es pot atacar
        return false;
    }

    public abstract boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu);
}
