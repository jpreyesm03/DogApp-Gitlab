import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your desired difficulty: ");
        String diff = scanner.nextLine();
        Game game = new Game(diff);

        while(!game.isGameOver())
        {
            System.out.print("Enter inputs(ROW,COLUMN): ");
            String coordinates = scanner.nextLine();


            game.playGame(coordinates);

        }

        scanner.close();
        if (game.won())

        {
            System.out.println("You won!");
        }

        else
        {
            System.out.println("You lost!");
        }


        /*
        for(int y =0;y<11;y++)
        {
            for(int x=0;x<11;x++)
                Tile tile = new Tile(x,y);
                board.getTiles[x][y] = tile;
        }

        crea

         */



    }

}
