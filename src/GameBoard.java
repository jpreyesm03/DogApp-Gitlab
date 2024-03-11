public class GameBoard {

    //Attributes
    private Tile[][] tiles;

    //Constructor
    public GameBoard(int rows, int columns) {
        tiles = new Tile[rows][columns];
        for (int r=0; r < rows; r++) {
            for (int c=0; c < columns; c++) {
                tiles[r][c] = new Tile(r, c);
            }
        }
    }

    public Tile getTile(int row, int column) {
        return tiles[row][column];
    }

    public Tile[][] getTiles() {
        return tiles;
    }




}
