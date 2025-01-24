class Fragata extends Nau {
    public Fragata(int fil, int col, String bandol) {
        super(fil, col, 'F', bandol);
    }

    @Override
    /**
     * Fragates (F): Es poden moure fins a 2 caselles en línia recta
     * i poden atacar naus enemigues a una distància màxima de 2 caselles.
     */
    public boolean esMovimentValid(int filOrigen, int colOrigen, int filDesti, int colDesti, char[][] matriu) {
        // Comprovar moviment horitzontal
        if (filOrigen == filDesti) {
            int distancia = Math.abs(colDesti - colOrigen);

            // Moviment a 1 casella horitzontal
            if (distancia == 1) {
                return esPotMoure(filDesti, colDesti, matriu);
            }

            // Moviment a 2 caselles horitzontal
            if (distancia == 2) {
                int intermCol = (colOrigen + colDesti) / 2; // Casella intermèdia
                if (!esPotMoure(filOrigen, intermCol, matriu)) {
                    return false; // La casella intermèdia no és vàlida
                }
                return esPotMoure(filDesti, colDesti, matriu); // Verificar destí
            }
        }

        // Comprovar moviment vertical
        if (colOrigen == colDesti) {
            int distancia = Math.abs(filDesti - filOrigen);

            // Moviment a 1 casella vertical
            if (distancia == 1) {
                return esPotMoure(filDesti, colDesti, matriu);
            }

            // Moviment a 2 caselles vertical
            if (distancia == 2) {
                int intermFil = (filOrigen + filDesti) / 2; // Casella intermèdia
                if (!esPotMoure(intermFil, colOrigen, matriu)) {
                    return false; // La casella intermèdia no és vàlida
                }
                return esPotMoure(filDesti, colDesti, matriu); // Verificar destí
            }
        }

        // Si no és en línia recta, el moviment no és vàlid
        return false;
    }
}
