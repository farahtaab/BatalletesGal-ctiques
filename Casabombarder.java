import java.util.ArrayList;
import java.util.List;

class CasaBombarder extends Nau {
	public CasaBombarder(int fil, int col, String bandol) {
		super(fil, col, 'C', bandol);
	}

	@Override
	public List<int[]> movimentsPossibles() {
		List<int[]> moviments = new ArrayList<>();
		// Es mou en "L" (com un cavall en escacs)
		int[] dFil = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dCol = { -1, 1, -2, 2, -2, 2, -1, 1 };

		for (int i = 0; i < dFil.length; i++) {
			int nouFil = fil + dFil[i];
			int nouCol = col + dCol[i];
			if (nouFil >= 0 && nouFil < 8 && nouCol >= 0 && nouCol < 8) {
				moviments.add(new int[] { nouFil, nouCol });
			}
		}
		return moviments;
	}
}