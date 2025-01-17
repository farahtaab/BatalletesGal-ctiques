class Exploradora extends Nau {
    public Exploradora(int fil, int col, String bandol) {
        super(fil, col, 'E', bandol);
    }

    @Override
    /**
     * Exploradores (E): Es mouen en diagonal qualsevol nombre de caselles, però no poden atacar.
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Comprovar que el moviment és diagonal
        if (Math.abs(filDesti - filOrigen) == Math.abs(colDesti - colOrigen)) {
            // Comprovar que totes les caselles intermitges estan lliures
            int dFil = (filDesti > filOrigen) ? 1 : -1; // Direcció files
            int dCol = (colDesti > colOrigen) ? 1 : -1; // Direcció columnes

            int filActual = filOrigen + dFil;
            int colActual = colOrigen + dCol;

            while (filActual != filDesti && colActual != colDesti) {
                if (posicioOcupada(filActual, colActual, matriu)) {
                    return false; // Una casella intermitja està ocupada
                }
                filActual += dFil;
                colActual += dCol;
            }

            // Comprovar que la casella de destí està dins i lliure (no poden atacar)
            return estaDins(filDesti, colDesti) && !posicioOcupada(filDesti, colDesti, matriu);
        }

        // No és un moviment diagonal
        return false;
    }

    @Override
    /**
     * Exploradores no poden atacar.
     */
    public boolean potAtacar(int filDesti, int colDesti, char[][] matriu) {
        return false; // Les exploradores mai poden atacar
    }
}
