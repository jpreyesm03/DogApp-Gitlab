import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private GameDifficulty difficulty;
    private boolean firstInput = true;


    private Input input;

    private ArrayList<String> coordinates;
    private boolean gameOver = false;

    private GameBoard board;
    private Scanner scanner;

    private Visualization visualization = new Visualization("🚩","💣","","‍☠️", "", "");

    public Game() {
        scanner = new Scanner(System.in);
        System.out.print("Enter your desired difficulty: ");
         String difficulty = scanner.nextLine();

        if (difficulty.equals("Easy") || difficulty.equals("easy") || difficulty.equals("EASY")) {
            this.difficulty = GameDifficulty.EASY;
        } else if (difficulty.equals("Medium") || difficulty.equals("medium") || difficulty.equals("MEDIUM")) {
            this.difficulty = GameDifficulty.MEDIUM;
        } else if (difficulty.equals("Hard") || difficulty.equals("hard") || difficulty.equals("HARD")) {
            this.difficulty = GameDifficulty.HARD;
        } else {
            System.out.println("Wrong input for difficulty selection. Difficulty automatically set to medium.");
            this.difficulty = GameDifficulty.MEDIUM;
        }

        System.out.print("Enter your first coordinates: ");
        String firstinp = scanner.nextLine();
        playGame(firstinp);



        Input input = new Input();











    }

    public boolean isGameOver() {

        return gameOver;
    }

    public void playGame(String firstinp)
    {

        while (input.getInputs(firstinp )[0] == -1 || input.getInputs(firstinp)[0] == -2 || firstinp.charAt(0) == 'F')
        {
            System.out.print("Enter correct coordinates:");
            firstinp = scanner.nextLine();

        }

        if(this.difficulty.equals(GameDifficulty.EASY))
        {
            board = new GameBoard(8,8, 10, input.getInputs(firstinp)[0], input.getInputs(firstinp)[1]);
        } else if (this.difficulty.equals(GameDifficulty.MEDIUM))
        {
            board = new GameBoard(16,16, 40, input.getInputs(firstinp)[0], input.getInputs(firstinp)[1]);
        } else if (this.difficulty.equals(GameDifficulty.HARD))
        {
            board = new GameBoard(16,30, 99, input.getInputs(firstinp)[0], input.getInputs(firstinp)[1]);
        }

        while (!isGameOver()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your coordinates: ");
            String rawCoordinates = scanner.nextLine();


            int[] currentCoords = input.getInputs(rawCoordinates);
            if (currentCoords[0] == -1) {
                System.out.println("Help:");
                help();
            } else if (currentCoords[0] == -2) {
                System.out.println("Wrong inputs, please type again");
            } else {
                if (firstInput) {
                    firstPlay(currentCoords[0], currentCoords[1]);
                    firstInput = false;
                } else {
                    otherPlay(currentCoords[0], currentCoords[1]);
                }
            }

            visualization.visualize(board);
        }
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
