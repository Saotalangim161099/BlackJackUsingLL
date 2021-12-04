import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        BlackJackGameDriver gameDriver = new BlackJackGameDriver();
        ArrayList<Player> players = new ArrayList<>();
        Player Toan = new Player("Toan", "12345");
        Player Bi = new Player("Bi", "6789");
        Player Bo = new Player("Bo", "1011");
        players.add(Toan);
        players.add(Bi);
        players.add(Bo);
        gameDriver.initGame(players, 1);

        while (!gameDriver.isGameFinished()) {
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("What your phone number?");
            String phoneNumber = scanner.nextLine();
            System.out.println("What is your move? (hit/stand)");
            String move = scanner.nextLine();
            gameDriver.processMove(new Move(phoneNumber, move));
        }
//        gameDriver.dealCards();
//        gameDriver.printStatus();


    }
}
