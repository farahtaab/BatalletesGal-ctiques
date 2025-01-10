import java.util.ArrayList;
import java.util.List;

class DronCombat extends Nau {
	public DronCombat(int fil, int col, String bandol) {
		super(fil, col, 'D', bandol);
	}

	@Override
	public List<int[]> movimentsPossibles() {
		List<int[]> moviments = new ArrayList<>();
		// Es mou una casella cap endavant i ataca en diagonal
		if (bandol.equals("Alfa")) {
			if (fil + 1 < 8) {
				moviments.add(new int[] { fil + 1, col });
			}
			if (fil + 1 < 8 && col + 1 < 8) {
				moviments.add(new int[] { fil + 1, col + 1 });
			}
			if (fil + 1 < 8 && col - 1 >= 0) {
				moviments.add(new int[] { fil + 1, col - 1 });
			}
		} else {
			if (fil - 1 >= 0) {
				moviments.add(new int[] { fil - 1, col });
			}
			if (fil - 1 >= 0 && col + 1 < 8) {
				moviments.add(new int[] { fil - 1, col + 1 });
			}
			if (fil - 1 >= 0 && col - 1 >= 0) {
				moviments.add(new int[] { fil - 1, col - 1 });
			}
		}
		return moviments;
	}
}
