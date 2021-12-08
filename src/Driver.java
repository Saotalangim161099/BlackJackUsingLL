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
        Player Jay = new Player("Jay", "246");
        Player Adam = new Player("Adam", "357");
        Player Sean = new Player("Adam", "000");
        players.add(Toan);
        players.add(Bi);
        players.add(Bo);
        players.add(Jay);
        players.add(Adam);
        players.add(Sean);
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
//        gameDriver.printStatus();*/
        /*ArrayList<Player> players = new ArrayList<>();
        Player Toan = new Player("Toan", "12345");
        CardHand THand=new CardHand();
        THand.addCard(new LLCard("10","D",null));
        THand.addCard(new LLCard("5","D",null));
        THand.addCard(new LLCard("6","D",null));
        Toan.setPlayerHand(THand);
        Player Bi = new Player("Bi", "6789");
        CardHand BHand=new CardHand();
        BHand.addCard(new LLCard("9","D",null));
        BHand.addCard(new LLCard("6","D",null));
        BHand.addCard(new LLCard("6","D",null));
        Bi.setPlayerHand(BHand);
        Player Bo = new Player("Bo", "1011");
        CardHand BOHand=new CardHand();
        BOHand.addCard(new LLCard("9","D",null));
        BOHand.addCard(new LLCard("6","D",null));
        BOHand.addCard(new LLCard("6","D",null));
        Bo.setPlayerHand(BOHand);
        Player Jay = new Player("Jay", "246");
        CardHand JHand=new CardHand();
        JHand.addCard(new LLCard("10","D",null));
        JHand.addCard(new LLCard("1","D",null));
        Jay.setPlayerHand(JHand);
        Player Adam = new Player("Adam", "357");
        CardHand AHand=new CardHand();
        AHand.addCard(new LLCard("10","D",null));
        AHand.addCard(new LLCard("5","D",null));
        Adam.setPlayerHand(AHand);
        players.add(Toan);
        players.add(Bi);
        players.add(Bo);
        players.add(Jay);
        players.add(Adam);
        BlackJackGameDriver driver=new BlackJackGameDriver(players);
        ArrayList list=driver.compareMultiple();
        for (int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }*/

    }
}
