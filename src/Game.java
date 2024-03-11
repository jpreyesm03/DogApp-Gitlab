import java.util.ArrayList;

public class Game {

    private GameDifficulty difficulty;
    private boolean firstInput;
    private ArrayList<String> coordinates;
    private boolean gameOver;

    private GameBoard board;

    public Game(String difficulty) {
        if (difficulty.equals("Easy")) {
            this.difficulty = GameDifficulty.EASY;
        } else if (difficulty.equals("Medium")) {
            this.difficulty = GameDifficulty.MEDIUM;
        } else if (difficulty.equals("Hard")) {
            this.difficulty = GameDifficulty.HARD;
        } else {
            System.out.println("Wrong input for difficulty selection. Difficulty automatically set to medium.");
            this.difficulty = GameDifficulty.MEDIUM;
        }

        board = new GameBoard(rows, columns);


    }


    public void playGame(String coords)
    {
        //Bunch of ifs... whatever whatever

        if (coords[0].equals("F")) {
            board.getTile(coords).flag();
        }

    }

    private void firstPlay(String coords)
    {

    }

    private void otherPlay(String coords)
    {

    }

    private void reveal()
    {

    }

    private void help()
    {

    }

    private int showNeighbors()
    {
        return -1;
    }

    private void createBoard()
    {

    }

    private void newGame()
    {

    }

    private boolean won()
    {
        return false;
    }

    private GameBoard getBoard()
    {
        return null;
    }





}
