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
        // Comprovar que el moviment és dins d'una casella (1 casella en qualsevol direcció)
        if (Math.abs(filOrigen - filDesti) <= 1 && Math.abs(colOrigen - colDesti) <= 1) {
            // Comprovar si es pot moure a la casella (buit o enemic)
            return esPotMoure(filDesti, colDesti, matriu);
        }

        // Si el moviment no compleix la distància d'una casella, no és vàlid
        return false;
    }
}
