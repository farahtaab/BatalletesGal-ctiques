public class Test {

    public static void main(String[] args) {
        // Tablero inicial
        char[][] matriu = {
            {'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd'},
            {'d', 'f', 'e', '.', '.', 'e', 'f', 'd'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'D', 'F', 'E', '.', '.', 'E', 'F', 'D'},
            {'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D'}
        };

        // Pruebas para cada tipo de nave
        provaNau(new Fragata(5, 1, "Alfa"), matriu, "Fragata"); // Fragata Alfa en (1, 1)
        provaNau(new NauMareComandant(3, 3, "Beta"), matriu, "Nau Mare Comandant"); // Nau Mare Comandant Beta en (4, 4)
        provaNau(new CasaBombarder(3, 3, "Alfa"), matriu, "Casa Bombarder"); // Casa Bombarder Alfa en (3, 3)
        provaNau(new Exploradora(6, 2, "Beta"), matriu, "Exploradora"); // Exploradora Beta en (6, 2)
        provaNau(new DronCombat(5, 4, "Alfa"), matriu, "Dron Combat"); // Dron Combat Alfa en (5, 4)
    }

    /**
     * Prova una nau i imprimeix el resultat dels moviments vàlids.
     */
    public static void provaNau(Nau nau, char[][] matriu, String nomNau) {
        System.out.println("\n--- Moviments per a " + nomNau + " ---");

        // Iterar sobre tot el tauler
        for (int fil = 0; fil < matriu.length; fil++) {
            for (int col = 0; col < matriu[fil].length; col++) {
                // Determinar si la posició és vàlida
                if (fil == nau.fil && col == nau.col) {
                    System.out.print("[A] "); // Posició actual
                } else if (nau.esMovimentValid(nau.fil, nau.col, fil, col, matriu)) {
                    System.out.print("[X] "); // Moviment vàlid
                } else {
                    System.out.print("[ ] "); // Moviment no vàlid
                }
            }
            System.out.println(); // Nova línia després de cada fila
        }
    }
}
