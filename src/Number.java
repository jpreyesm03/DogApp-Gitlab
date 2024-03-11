import java.util.Random;

public class Number extends Tile {
    private int neighbors;

    protected Number(int row, int column) {
        super(row, column);

    }

    public boolean open() {
        return true;
    }

    public int neighbors() {
        return -1;
    }

    public int getNeighbors() {
        return neighbors;
    }
}
