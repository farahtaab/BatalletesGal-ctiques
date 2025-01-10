import java.util.ArrayList;
import java.util.List;

class Fragata extends Nau {
	public Fragata(int fil, int col, String bandol) {
		super(fil, col, 'F', bandol);
	}

	@Override
	public List<int[]> movimentsPossibles() {
		List<int[]> moviments = new ArrayList<>();
		// Fins a 2 caselles en línia recta
		for (int i = 1; i <= 2; i++) {
			if (fil + i < 8) {
				moviments.add(new int[] { fil + i, col });
			}
			if (fil - i >= 0) {
				moviments.add(new int[] { fil - i, col });
			}
			if (col + i < 8) {
				moviments.add(new int[] { fil, col + i });
			}
			if (col - i >= 0) {
				moviments.add(new int[] { fil, col - i });
			}
		}
		return moviments;
	}
}