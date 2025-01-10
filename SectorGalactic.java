
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
	// li pasem la nau, la cord de la fila i columna
	public void colocar_la_nau(Nau nau, int x, int y) {
		// si el tauler esta buit li pasem una nau
		if (tauler[x][y] == null) {
			tauler[x][y] = nau;
		}
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
		
		if (nauDesti != null && nauDesti.getBandol().equals(nau.getBandol())) {
			return false; // perque la nau esta ocupada per una nau aliada	
		}

		return true;
	}

	// metode per moure la nau de posicio

	public boolean MourelaNau(int iniciX, int iniciY, int destiX, int destiY) {
		// li passem a la nau la posicio de origen
		Nau nau = tauler[iniciX][iniciY];

		if (nau != null && esMovimentValid(nau, destiX, destiY)) {

			// li passem el desti NOU i tornem a definir el inici o origen a NULL
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
					System.out.print(tauler[fil][col].getTipus() + " ");

				}
			}
		}
		System.out.println();
	}

}
