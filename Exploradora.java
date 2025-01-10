import java.util.ArrayList;
import java.util.List;

class NauMareComandant extends Nau {
	public NauMareComandant(int fil, int col, String bandol) {
		super(fil, col, 'M', bandol);
	}

	@Override
	public List<int[]> movimentsPossibles() {
		List<int[]> moviments = new ArrayList<>();
		// Mou en diagonal qualsevol nombre de caselles
		for (int i = 1; i < 8; i++) {
			if (fil + i < 8 && col + i < 8) {
				moviments.add(new int[] { fil + i, col + i });
			}
			if (fil + i < 8 && col - i >= 0) {
				moviments.add(new int[] { fil + i, col - i });
			}
			if (fil - i >= 0 && col + i < 8) {
				moviments.add(new int[] { fil - i, col + i });
			}
			if (fil - i >= 0 && col - i >= 0) {
				moviments.add(new int[] { fil - i, col - i });
			}
		}
		return moviments;
	}
}
