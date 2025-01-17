class NauMareComandant extends Nau {
    public NauMareComandant(int fil, int col, String bandol) {
        super(fil, col, 'M', bandol);
    }

    @Override
    /**
     * Es mou una casella en qualsevol direcció.
     * Pot atacar si la casella de destí està ocupada per un enemic.
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Comprovar que el moviment és dins d'una casella
        if (Math.abs(filOrigen - filDesti) <= 1 && Math.abs(colOrigen - colDesti) <= 1) {
            // Comprovar que la casella està dins del tauler
            if (!estaDins(filDesti, colDesti)) {
                return false; // Destí fora del tauler
            }

            // Si la casella està ocupada
            if (posicioOcupada(filDesti, colDesti, matriu)) {
                return potAtacar(filDesti, colDesti, matriu); // Només es pot moure si pot atacar
            }

            // Si la casella no està ocupada, el moviment és vàlid
            return true;
        }

        // Si no és una casella, no és un moviment vàlid
        return false;
    }
}
