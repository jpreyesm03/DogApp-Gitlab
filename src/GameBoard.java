import java.util.ArrayList;

public class GameBoard {

    //Attributes
    private Tile[][] tiles;
    private ArrayList<Integer[]> bombCoordinates;

    //Constructor
    public GameBoard(int rows, int columns, int bombs, int inputRow, int inputColumn) {
        tiles = new Tile[rows][columns];
        bombCoordinates = new RandomCoordinates(rows, columns, bombs, inputRow, inputColumn).getRandomCoordinates();
        for (Integer[] b: bombCoordinates) {
            tiles[b[0]][b[1]] = new Bomb(b[0], b[1]);
        }

        for (int r=0; r < rows; r++) {
            for (int c=0; c < columns; c++) {
                if (!(tiles[r][c] instanceof Bomb)) {
                    tiles[r][c] = new Number(r,c);
                }
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
