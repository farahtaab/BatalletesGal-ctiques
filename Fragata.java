class Fragata extends Nau {
    public Fragata(int fil, int col, String bandol) {
        super(fil, col, 'F', bandol);
    }

    @Override
    /**
     * Fragates (F): Mouen fins a 2 caselles en línia recta i poden atacar naus
     * a una distància màxima de 2 caselles.
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Moviment horitzontal
        if (filOrigen == filDesti) {
            int distancia = Math.abs(colDesti - colOrigen);

            if (distancia == 1) { // Mou 1 casella
                return !posicioOcupada(filDesti, colDesti, matriu) || potAtacar(filDesti, colDesti, matriu);
            } else if (distancia == 2) { // Mou 2 caselles
                int intermCol = (colOrigen + colDesti) / 2; // Casella intermèdia
                return !posicioOcupada(filOrigen, intermCol, matriu) &&
                       (!posicioOcupada(filOrigen, colDesti, matriu) || potAtacar(filOrigen, colDesti, matriu));
            }

        // Moviment vertical
        } else if (colOrigen == colDesti) {
            int distancia = Math.abs(filDesti - filOrigen);

            if (distancia == 1) { // Mou 1 casella
                return !posicioOcupada(filDesti, colDesti, matriu) || potAtacar(filDesti, colDesti, matriu);
            } else if (distancia == 2) { // Mou 2 caselles
                int intermFil = (filOrigen + filDesti) / 2; // Casella intermèdia
                return !posicioOcupada(intermFil, colOrigen, matriu) &&
                       (!posicioOcupada(filDesti, colOrigen, matriu) || potAtacar(filDesti, colOrigen, matriu));
            }
        }

        // Si no és en línia recta, el moviment no és vàlid
        return false;
    }
}
