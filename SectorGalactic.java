
public class SectorGalactic {

	// creamos una matriz de 8x8

	// metodes a utilizar
	// - posar_nau(nau, x, y) -- lo que fa aquest metode es colocar la nau al tauler
	// - moure_nau(origen, destí) -- lo que fa aquest metode es moure
	// la nau d'una posicio a una altre si el moviment es valid
	// - es_moviment_valid(nau, destí) -- lo que fa aquest metode si comprovar si
	// segueix les regles
	// - mostrar_tauler() -- lo que fa aquest metode imprimeix el tauler formatejat
	// correcte

	// creem la matriu de 8x8 que utilitzarem
	private Nau[][] tauler;

	// Constructor amb els parametres
	public SectorGalactic(Nau[][] tauler) {
		this.tauler = new Nau[8][8];
		iniciarTauler();
	}
    /**
     * Inicialitza el tauler amb la configuració inicial.
     */
        private void iniciarTauler() {
        // Configuració inicial per al bàndol Alfa
        tauler[0][0] = new CasaBombarder(0, 0, "Alfa");
        tauler[0][1] = new DronCombat(0, 1, "Alfa");
        tauler[0][2] = new DronCombat(0, 2, "Alfa");
        tauler[0][3] = new Exploradora(0, 3, "Alfa");
        tauler[0][4] = new Fragata(0, 4, "Alfa");
        tauler[0][5] = new NauMareComandant(0, 5, "Alfa");
        tauler[0][6] = new Fragata(0, 6, "Alfa");
        tauler[0][7] = new DronCombat(0, 7, "Alfa");

        tauler[1][0] = new DronCombat(1, 0, "Alfa");
        tauler[1][1] = new Fragata(1, 1, "Alfa");
        tauler[1][2] = new Exploradora(1, 2, "Alfa");
        tauler[1][5] = new Exploradora(1, 5, "Alfa");
        tauler[1][6] = new Fragata(1, 6, "Alfa");
        tauler[1][7] = new DronCombat(1, 7, "Alfa");

        // Configuració inicial per al bàndol Beta
        tauler[7][0] = new CasaBombarder(7, 0, "Beta");
        tauler[7][1] = new DronCombat(7, 1, "Beta");
        tauler[7][2] = new DronCombat(7, 2, "Beta");
        tauler[7][3] = new Exploradora(7, 3, "Beta");
        tauler[7][4] = new Fragata(7, 4, "Beta");
        tauler[7][5] = new NauMareComandant(7, 5, "Beta");
        tauler[7][6] = new Fragata(7, 6, "Beta");
        tauler[7][7] = new DronCombat(7, 7, "Beta");

        tauler[6][0] = new DronCombat(6, 0, "Beta");
        tauler[6][1] = new Fragata(6, 1, "Beta");
        tauler[6][2] = new Exploradora(6, 2, "Beta");
        tauler[6][5] = new Exploradora(6, 5, "Beta");
        tauler[6][6] = new Fragata(6, 6, "Beta");
        tauler[6][7] = new DronCombat(6, 7, "Beta");
    }
	// metodes
	// coloca una Nau en una posicio del tauler
	public boolean colocar_la_nau(Nau nau, int x, int y) {
		// comprova la posicio que estigui dins dels limits i que també estigui buit
		if (x >= 0 && x < 8 && y >= 0 && y < 8 && tauler[x][y] == null) {
			// li passem la nau a la nova posició
			tauler[x][y] = nau;
            return true;
		}
		// si no s'ha pogut colocar retorna false
		return false;	
	}

	// metode boolean que comprovara si es valid el moviment
	// comprovem les regles del tius de Nau
	public boolean esMovimentValid(Nau nau, int movimentDestiX, int movimentDestiY) {
		// la logica de cada una de les naus
		
		// Comprovo que la casella de desti no estigui plena per una nau aliada
		Nau nauDesti = tauler[movimentDestiX][movimentDestiY];

		return true;
	}

	// metode per moure la nau de posicio
	public boolean MourelaNau(int iniciX, int iniciY, int destiX, int destiY) {
		// li passem a la nau la posicio de origen
		Nau nau = tauler[iniciX][iniciY];

		// Si la nau existeix i els moviments cumpleixen les regles
		if (nau != null && nau.esMovimentValid(iniciX, iniciY, destiX, destiY, convertirATaulerChars())) {
			
			 // Si hi ha una nau enemiga, es considera atacada
	        if (tauler[iniciX][iniciY] != null) {
	            System.out.println("La nau enemiga a [" + iniciX + "][" + iniciY + "] ha estat destruïda.");
	        }
			// li passem el desti NOU i tornem a definir el inici a origen buida
			tauler[destiX][destiY] = nau;
			tauler[iniciX][iniciY] = null;

	        // Si hi ha una nau enemiga, es considera atacada
	        if (tauler[iniciY][destiY] != null) {
	            System.out.println("La nau enemiga a [" + iniciY + "][" + destiY + "] ha estat destruïda.");
	        }
			return true;		
		}
		return false;
	}

	// metode que mostra el tauler
	public void mostrarTauler() {
		// ETIQUETES A UTILITZAR EN LES COLUMNES
        System.out.println("    a   b   c   d   e   f   g   h ");
        System.out.println("  +---+---+---+---+---+---+---+---+");
		// recorrem el tauler i imprimim
		for (int fil = 0; fil < 8; fil++) {
            for (int col = 0; col < 8; col++) {
                if (tauler[fil][col] != null) {
                	// mostrem quin tipus de nau si existeix
                    System.out.print(tauler[fil][col].getTipus() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+"); // Línia separadora

        }
	}
	// metode per convertir el tauler en una matriu de chars
	 private char[][] convertirATaulerChars() {
	        char[][] matriu = new char[8][8];
	        // recorrem el tauler
	        for (int fil = 0; fil < 8; fil++) {
	            for (int col = 0; col < 8; col++) {
	                matriu[fil][col] = (tauler[fil][col] != null) ? tauler[fil][col].getTipus() : '.';
	            }
	        }
	        // retorna la matriu
	        return matriu;
	    }

}