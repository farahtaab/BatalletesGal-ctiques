import java.util.List;

abstract class Nau {
    protected int fil;
    protected int col;
    protected char tipus;
    protected String bandol;

    public Nau(int fil, int col, char tipus, String bandol) {
        this.fil = fil;
        this.col = col;
        this.tipus = tipus;
        this.bandol = bandol;
    }

    public char getTipus() {
        return tipus;
    }

    public String getBandol() {
        return bandol;
    }

    public abstract List<int[]> movimentsPossibles();
}