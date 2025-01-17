class CasaBombarder extends Nau {
    public CasaBombarder(int fil, int col, String bandol) {
        super(fil, col, 'C', bandol);
    }

    @Override
    /**
     * Caçabombarders (C): Es mouen com el cavall en escacs (en L) i poden destruir
     * qualsevol nau que ocupi la casella de destí. Aquesta és l'única nau que pot
     * saltar per sobre d'altres.
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Calcular la diferencia entre les coordenades
        int difFil = Math.abs(filOrigen - filDesti);
        int difCol = Math.abs(colOrigen - colDesti);

        // Comprovar si el moviment forma una 'L' (2x1 o 1x2)
        if ((difFil == 2 && difCol == 1) || (difFil == 1 && difCol == 2)) {
            // Comprovar que la casella de destí està dins del tauler
            if (!estaDins(filDesti, colDesti)) {
                return false; // Destí fora del tauler
            }

            // Comprovar si la casella de destí està ocupada
            if (posicioOcupada(filDesti, colDesti, matriu)) {
                return potAtacar(filDesti, colDesti, matriu); // Només pot moure si pot atacar
            }

            // Si la casella està buida, el moviment és vàlid
            return true;
        }

        // Si no forma una 'L', no és un moviment vàlid
        return false;
    }
}
