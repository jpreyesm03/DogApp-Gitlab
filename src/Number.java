public class Number extends Tile {
    private int neighbors;

    public boolean open() {
        return true;
    }

    public int neighbors() {
        return -1;
    }
}
