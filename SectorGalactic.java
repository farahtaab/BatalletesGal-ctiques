
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
		
		// primer hem de comprovar si la casella de desti esta dins del rang del tauler
		if (movimentDestiX < 0 || movimentDestiX >= 8 || movimentDestiY < 0 || movimentDestiY >= 8) {
            return false;  // Fora del tauler
        }
		
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

			// li passem el desti NOU i tornem a definir el inici a origen buida
			tauler[destiX][destiY] = nau;
			tauler[iniciX][iniciY] = null;
			return true;
		}
		return false;
	}

	// metode que mostra el tauler
	public void mostrarTauler() {
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