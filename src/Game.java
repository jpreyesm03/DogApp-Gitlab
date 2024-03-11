import java.util.ArrayList;

public class Game {

    private GameDifficulty difficulty;
    private boolean firstInput;
    private ArrayList<String> coordinates;
    private boolean gameOver;

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


    }

    public void playGame(String coords)
    {

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
