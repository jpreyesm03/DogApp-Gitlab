import java.util.ArrayList;

public class Game {

    private GameDifficulty difficulty;
    private boolean firstInput;
    private Input input;
    private int i=0;
    private int[] currentInputs;


    private ArrayList<String> coordinates;
    private boolean gameOver = false;

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

        Input input = new Input();



    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void playGame(String coords)
    {
        currentInputs = input.getInputs(coords);

    }

    private void firstPlay(String coords)
    {

    }

    private void otherPlay(String coords)
    {

    }

    private void reveal()
    {
        gameOver = true;

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

    public void newGame()
    {
        gameOver=false;

    }

    public boolean won()
    {
       gameOver=true;
       return true;
    }

    private GameBoard getBoard()
    {
        return null;
    }





}
