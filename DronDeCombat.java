class DronCombat extends Nau {
    public DronCombat(int fil, int col, String bandol) {
        super(fil, col, 'D', bandol);
    }

    @Override
    /**
     * Els drons es mouen una casella cap endavant i poden atacar
     * en diagonal cap endavant (com els peons dels escacs).
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Determinar la direcció del moviment segons el bàndol
        int direccio = bandol.equals("Alfa") ? -1 : 1;

        // Moviment endavant (una casella cap endavant)
        if (colOrigen == colDesti && filDesti == filOrigen + direccio) {
            // Comprovar que es pot moure (només si està buida)
            return esPotMoure(filDesti, colDesti, matriu) && !estemAtacant(filDesti, colDesti, matriu);
        }

        // Atac diagonal cap endavant (una casella)
        if (Math.abs(colDesti - colOrigen) == 1 && filDesti == filOrigen + direccio) {
            // Comprovar si es pot atacar (només si hi ha un enemic)
            return estemAtacant(filDesti, colDesti, matriu);
        }

        // Si no compleix cap condició, el moviment no és vàlid
        return false;
    }
}
