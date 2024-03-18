import static java.lang.Math.abs;

public class Number extends Tile {
    private int neighbors;


    protected Number(int row, int column) {
        super(row, column);

    }

    public boolean open() {

        if (neighbors == 0) {
            for (int r=0; r < tiles.length; r++) {
                for (int c = 0; c < tiles[r].length; c++) {
                    if (tiles[r][c] instanceof Bomb) {
                        continue;
                    }
                    else {
                        if (!(r == getRow() && c == getColumn())) {
                            if ((abs(r - getRow()) <= 1 && abs(c - getColumn()) <= 1) && !getReveal()) {
                                tiles[r][c].open();
                            }
                        }
                    }

                }
            }
        }
        return true;
    }

    public void neighbors(Tile[][] tiles) {
        int nrNeighbors = 0;
            for (int r=0; r < tiles.length; r++) {
                for (int c = 0; c < tiles[r].length; c++) {
                    if (!(r == getRow() && c == getColumn())) {
                        if ((abs(r - getRow()) <= 1 && abs(c - getColumn()) <= 1) && tiles[r][c] instanceof Bomb) {
                            nrNeighbors++;
                        }
                    }
                }
            }
        this.neighbors = nrNeighbors;
    }

    public int getNeighbors() {
        return neighbors;
    }
}
