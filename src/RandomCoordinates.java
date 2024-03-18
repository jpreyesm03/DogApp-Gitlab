import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class RandomCoordinates {
    private ArrayList<Integer[]> randomCoordinates;
    private int rows;
    private int columns;
    private int bombs;
    private int inputRow;
    private int inputColumn;

    public RandomCoordinates(int rows, int columns, int bombs, int inputRow, int inputColumn) {
        randomCoordinates = new ArrayList<>();
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
        this.inputRow = inputRow;
        this.inputColumn = inputColumn;
    }

    private void randomTuples() {
        while (randomCoordinates.size() < bombs) {
            Integer[] localTuple = new Integer[2];
            while (isRepeated(localTuple) || firstTryViolation(localTuple)) {
                Integer bombRow = new Random().nextInt(rows);
                Integer bombColumn = new Random().nextInt(columns);
                localTuple[0] = bombRow;
                localTuple[1] = bombColumn;
            }
            randomCoordinates.add(localTuple);
        }
    }


    private boolean isRepeated(Integer[] tuple) {
        if (tuple[0] == null && tuple[1] == null) {
            return false;
        }
        else {
            for (Integer[] bombPos: randomCoordinates) {
                if (bombPos[0] == tuple[0] && bombPos[1] == tuple[1]) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean firstTryViolation(Integer[] localTuple) {
        if (abs(localTuple[0] - inputRow) <= 1 && abs(localTuple[1] - inputColumn) <= 1) {
            return true;
        }
        else {
            return false;
        }
    }


    public ArrayList<Integer[]> getRandomCoordinates() {
        randomTuples();
        return randomCoordinates;
    }
}
