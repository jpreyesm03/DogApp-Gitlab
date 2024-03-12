import java.util.ArrayList;

public class Game {

    private GameDifficulty difficulty;
    private boolean firstInput;

    private int i = 0;
    private Input input;

    private ArrayList<String> coordinates;
    private boolean gameOver = false;

    private GameBoard board;

    private Visualization visualization = new Visualization("🚩","💣","","‍☠️", "", "");

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
        if(this.difficulty.equals(GameDifficulty.EASY))
        {
            GameBoard board = new GameBoard(8,8, 10, input.getInputs(coords)[0], input.getInputs(coords)[1]);
        } else if (this.difficulty.equals(GameDifficulty.MEDIUM))
        {
            GameBoard board = new GameBoard(16,16, 40, input.getInputs(coords)[0], input.getInputs(coords)[1]);
        } else if (this.difficulty.equals(GameDifficulty.HARD))
        {
            GameBoard board = new GameBoard(16,30, 99, input.getInputs(coords)[0], input.getInputs(coords)[1]);
        }




        int[] currentCoords = input.getInputs(coords);
        if(currentCoords[0] == -1)
        {
            System.out.println("Help:");
            help();
        }
        else if (currentCoords[0]==-2)
        {
            System.out.println("Wrong inputs, please type again");
        }
        else
        {
            if (i == 0)
            {
                firstPlay(currentCoords[0],currentCoords[1]);
            }
            else
            {
                otherPlay(currentCoords[0],currentCoords[1]);
            }
        }
        i++;

        visualization.visualize(board);
    }

    private void firstPlay(int x,int y)
    {

    }

    private void otherPlay(int x,int y)
    {
       Tile playedTile =  board.getTile(x,y);
       if(playedTile.getClickable())
       {
           playedTile.setReveal(true);
       }
       else {
           System.out.println("Not clickable tile!");
       }


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



    public void newGame()
    {
        gameOver=false;

    }

    public boolean won()
    {
       gameOver=true;
       board.setGameOver(true);
       return true;
    }

    public GameBoard getBoard() {
        return board;
    }
}
