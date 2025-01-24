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
            int dFil = (filDesti > filOrigen) ? 1 : -1; // Direcció de moviment en files
            int dCol = (colDesti > colOrigen) ? 1 : -1; // Direcció de moviment en columnes

            int filActual = filOrigen + dFil;
            int colActual = colOrigen + dCol;

            // Comprovar caselles intermitges
            while (filActual != filDesti && colActual != colDesti) {
                if (matriu[filActual][colActual] != '.') {
                    return false; // Una casella intermitja està ocupada
                }
                filActual += dFil;
                colActual += dCol;
            }

            // Comprovar que la casella de destí està buida
            return estaDins(filDesti, colDesti) && matriu[filDesti][colDesti] == '.';
        }

        // Si no és un moviment diagonal, no és vàlid
        return false;
    }
}
