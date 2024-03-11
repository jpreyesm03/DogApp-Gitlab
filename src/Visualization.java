public class Visualization {
    //Attributes


    //Methods
    public Visualization() {

    }

    public void visualize(GameBoard board) {
        Tile[][] tiles = board.getTiles();
        for (int row=0; row < tiles.length; row++) {
            for (int column=0; column < tiles[row].length; column++) {
                Tile tile = tiles[row][column];
                if (!isGameOver()) {
                    if (!tile.getClickable()) {
                        System.out.print(" F ");
                    }
                    else {
                        if (tile.getReveal()) {
                            System.out.print(" " + tile.getNeighbors() + " ");
                        }
                        else {
                            System.out.print(" - ");
                        }

                    }
                }
                else {
                    if (tile instanceof Bomb) {
                        System.out.print(" B ");
                    }
                    else {
                        System.out.print(" " + tile.getNeighbors() + " ");
                    }
                }
            }
            System.out.println();
        }
    }

}
