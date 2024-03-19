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
        } else {
            this.visualizeFlag = visualizeFlag;
        }
        if (visualizeBomb.isEmpty()) {
            this.visualizeBomb = "B";
        } else {
            this.visualizeBomb = visualizeBomb;
        }
        if (visualizeNumber.equals("Emoji") || visualizeNumber.equals("emoji") || visualizeNumber.equals("EMOJI") || visualizeNumber.equals("Emojis") || visualizeNumber.equals("emojis") || visualizeNumber.equals("EMOJIS")) {
            this.visualizeNumber = " 1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣";
        } else {
            this.visualizeNumber = " 12345678";
        }
        if (visualizeWrongFlag.isEmpty()) {
            this.visualizeWrongFlag = "X";
        } else {
            this.visualizeWrongFlag = visualizeWrongFlag;
        }
        if (visualizeEmptyTile.isEmpty()) {
            this.visualizeEmptyTile = ".";
        } else {
            this.visualizeEmptyTile = visualizeEmptyTile;
        }
        if (visualizeUnknown.isEmpty()) {
            this.visualizeUnknown = "-";
        } else {
            this.visualizeUnknown = visualizeUnknown;
        }


    }

    public void visualize(GameBoard board) {

        Tile[][] tiles = board.getTiles();
        String spacer = " ";

        horizontalDivider(tiles);

        for (int row = 0; row < tiles.length; row++) {
            if (tiles.length > 10) {
                if (row < 10) {
                    System.out.print(row + "  |");
                }
                else {
                    System.out.print(row + " |");
                }
            }
            else {
                System.out.print(row + " |");
            }

            for (int column = 0; column < tiles[row].length; column++) {
                Tile tile = tiles[row][column];
                if (tiles.length > 10) {
                    spacer = "  ";
                }
                else {
                    spacer = " ";
                }
                if (!board.isGameOver()) {

                    if (!tile.getClickable()) {
                        System.out.print(" " + visualizeFlag + spacer);
                    } else {
                        if (tile.getReveal()) {
                            int neighbors = ((Number) tile).getNeighbors();

                            if (neighbors == 0) {
                                System.out.print(" " + visualizeEmptyTile + spacer);
                            } else {
                                System.out.print(" " + visualizeNumber.charAt(neighbors) + spacer);
                            }

                        } else {
                            System.out.print(" " + visualizeUnknown + spacer);
                        }

                    }
                } else {
                    if (tile instanceof Bomb) {
                        if (!tile.getClickable()) {
                            System.out.print(" " + visualizeFlag + spacer);
                        }
                        else {
                            System.out.print(" " + visualizeBomb + spacer);
                        }
                    } else {
                        if (!tile.getClickable()) {
                            System.out.print(" " + visualizeWrongFlag + spacer);
                        } else {
                            int neighbors = ((Number) tile).getNeighbors();


                            if (neighbors == 0) {
                                System.out.print(" " + visualizeEmptyTile + spacer);
                            } else {
                                System.out.print(" " + visualizeNumber.charAt(neighbors) + spacer);
                            }
                        }
                    }

                }
            }
            System.out.println();
        }
    }

    private void horizontalDivider(Tile[][] tiles) {
        if (tiles[0].length > 10) {
            System.out.print("    ");
            for (int i = 0; i < tiles[0].length - 1; i++) {
                if (i < 10) {
                    System.out.print(" " + i + "  ");
                }
                else {
                    System.out.print(" " + i + " ");
                }
            }
            System.out.print(" " + (tiles[0].length - 1) + "\n");
            for (int i = 0; i < tiles[0].length * 4 + 4; i++) {
                System.out.print("-");
            }
        }
        else {
            System.out.print("   ");
            for (int i = 0; i < tiles[0].length - 1; i++) {
                System.out.print(" " + i + " ");
            }
            System.out.print(" " + (tiles[0].length - 1) + "\n");
            for (int i = 0; i < tiles[0].length * 3 + 3; i++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

}
