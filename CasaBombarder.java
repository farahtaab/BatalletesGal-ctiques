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
        // Calcular la diferència entre les coordenades
        int difFil = Math.abs(filOrigen - filDesti);
        int difCol = Math.abs(colOrigen - colDesti);

        // Comprovar si el moviment forma una 'L' (2x1 o 1x2)
        if ((difFil == 2 && difCol == 1) || (difFil == 1 && difCol == 2)) {
            // Reutilitzar esPotMoure per validar el moviment
            return esPotMoure(filDesti, colDesti, matriu);
        }

        // Si no forma una 'L', no és un moviment vàlid
        return false;
    }
}
