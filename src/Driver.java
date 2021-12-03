import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
       Scanner scanner = new Scanner(System.in);
        BlackJackGameDriver gameDriver = new BlackJackGameDriver();
        ArrayList<Player> players = new ArrayList<>();
        Player Toan = new Player("Toan","12345");
        Player Bi = new Player("Bi","6789");
        players.add(Toan);
        players.add(Bi);
        gameDriver.initGame(players,1);
        for (Player player:players){
            System.out.println(player.getName());
            gameDriver.dealCard(player);
            gameDriver.dealCard(player);
            player.printPlayerHand();
            System.out.println("Current total point: "+player.getTotalPointPlayerHand());

        }

        while(!gameDriver.isGameFinished())
        {
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("What your phone number?");
            String phoneNumber = scanner.nextLine();
            System.out.println("What is your move? (hit/stand)");
            String move = scanner.nextLine();
            gameDriver.processMove(new Move(new Player(name,phoneNumber),move));
        }
//        gameDriver.dealCards();
//        gameDriver.printStatus();



    }
}
