import java.util.HashMap;

public class Visualization {
    //Attributes
    private String visualizeFlag;
    private String visualizeBomb;
    private String visualizeNumber;
    private String visualizeWrongFlag;
    private String visualizeEmptyTile;
    private String visualizeUnknown;


    //Methods
    //Constructor... needed?


    public Visualization(String visualizeFlag, String visualizeBomb, String visualizeNumber, String visualizeWrongFlag, String visualizeEmptyTile, String visualizeUnknown) {
        if (visualizeFlag.isEmpty()) {
            this.visualizeFlag = "F";
        }
        else {
            this.visualizeFlag = visualizeFlag;
        }
        if (visualizeBomb.isEmpty()) {
            this.visualizeBomb = "B";
        }
        else {
            this.visualizeBomb = visualizeBomb;
        }
        if (visualizeNumber.equals("Emoji") || visualizeNumber.equals("emoji") || visualizeNumber.equals("EMOJI") || visualizeNumber.equals("Emojis") || visualizeNumber.equals("emojis") || visualizeNumber.equals("EMOJIS")) {
            this.visualizeNumber = " 1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣";
        }
        else {
           this. visualizeNumber = " 12345678";
        }
        if (visualizeWrongFlag.isEmpty()) {
            this.visualizeWrongFlag = "X";
        }
        else {
            this.visualizeWrongFlag = visualizeWrongFlag;
        }
        if (visualizeEmptyTile.isEmpty()) {
            this.visualizeEmptyTile = ".";
        }
        else {
            this.visualizeEmptyTile = visualizeEmptyTile;
        }
        if (visualizeUnknown.isEmpty()) {
            this.visualizeUnknown = "-";
        }
        else {
            this.visualizeUnknown = visualizeUnknown;
        }




    }

    public void visualize(GameBoard board) {
        Tile[][] tiles = board.getTiles();
        for (int row=0; row < tiles.length; row++) {
            for (int column=0; column < tiles[row].length; column++) {
                Tile tile = tiles[row][column];
                if (!board.isGameOver()) {
                    if (!tile.getClickable()) {
                        System.out.print(" " + visualizeFlag+ " ");
                    }
                    else {
                        if (tile.getReveal()) {
                            int neighbors = ((Number) tile).getNeighbors();

                            if (neighbors == 0 ) {
                                System.out.print(" " + visualizeEmptyTile+ " ");
                            }
                            else {
                                System.out.print(" " + visualizeNumber.charAt(neighbors) + " ");
                            }

                        }
                        else {
                            System.out.print(" " + visualizeUnknown + " ");
                        }

                    }
                }
                else {
                    if (tile instanceof Bomb) {
                        if (!tile.getClickable()) {
                            System.out.print(" " + visualizeWrongFlag + " ");
                        }
                        else {
                            System.out.print(" " + visualizeBomb+ " ");
                        }
                    }
                    else {
                        if (!tile.getClickable()) {
                            System.out.print(" " + visualizeFlag+ " ");
                        }
                        else {
                            int neighbors = ((Number) tile).getNeighbors();


                            if (neighbors == 0) {
                                System.out.print(" " + visualizeEmptyTile + " ");
                            } else {
                                System.out.print(" " + visualizeNumber.charAt(neighbors) + " ");
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

}
