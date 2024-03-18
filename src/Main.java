import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {

        GameBoard board = new GameBoard(9, 9, 5, 6, 7);
        board.getTile(6,7).open();
        System.out.println(((Number) board.getTile(6,7)).getNeighbors());
        Visualization visualization = new Visualization("🚩","💣","","‍☠️", "0", "");

        visualization.visualize(board);
        for (Integer[] localTuple: board.getBombCoordinates()) {
            if (abs(localTuple[0] - 6) <= 1 && abs(localTuple[1] - 7) <= 1) {
                System.out.print("(" + localTuple[0] + ", " + localTuple[1] + "), ");
            }
//
        }


    }

}
