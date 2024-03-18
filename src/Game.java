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



        input = new Input();
        playGame();



    }

    public boolean isGameOver() {

        return gameOver;
    }

    public void playGame()
    {

        gameOver = false;
        System.out.print("Enter your first coordinates: ");
        String firstinp = scanner.nextLine();


        while (input.getInputs(firstinp )[0] == -1 || input.getInputs(firstinp)[0] == -2 || firstinp.charAt(0) == 'F')
        {
            System.out.print("Enter correct coordinates:");
            firstinp = scanner.nextLine();

        }

        if(this.difficulty.equals(GameDifficulty.EASY))
        {
            board = new GameBoard(8,8, 10, input.getInputs(firstinp)[1], input.getInputs(firstinp)[0]);
        } else if (this.difficulty.equals(GameDifficulty.MEDIUM))
        {
            board = new GameBoard(16,16, 40, input.getInputs(firstinp)[1], input.getInputs(firstinp)[0]);
        } else if (this.difficulty.equals(GameDifficulty.HARD))
        {
            board = new GameBoard(16,30, 99, input.getInputs(firstinp)[1], input.getInputs(firstinp)[0]);
        }

        while (!isGameOver()) {
            input.setFlag(false);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your coordinates: ");
            String rawCoordinates = scanner.nextLine();


            int[] currentCoords = input.getInputs(rawCoordinates);
            if (currentCoords[0] == -1) {
                System.out.println("Help:");
                System.out.println("Flag info, format, type of inputs etc, write complete later");

            }
            else if (currentCoords[0] == -3)
            {
                playGame();
            }
                else if (currentCoords[0] == -2) {
                System.out.println("Wrong inputs, please type again");
            }
                 else
                 {
                    if (input.getFlag())
                    {
                        board.getTile(currentCoords[1], currentCoords[0]).flag();
                    }
                    else
                    {
                        otherPlay(currentCoords[1], currentCoords[0]);
                    }

                }

            visualization.visualize(board);

                 if (board.unopenedTiles() == board.getBombsNr())
                 {
                     gameOver = true;
                     board.setGameOver(true);
                 }




        }
    }



    private void otherPlay(int x,int y)
    {
       Tile playedTile =  board.getTile(x,y);
       if(playedTile.getClickable())
       {
           playedTile.setReveal(true);
           if (!playedTile.open()) {
               gameOver = true;
               board.setGameOver(true);
           }
       }
       else {
           System.out.println("Not clickable tile!");
       }


    }





    public GameBoard getBoard() {
        return board;
    }
}
