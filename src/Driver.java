import java.util.ArrayList;
import java.util.Arrays;
public class Driver {
    public static void main(String args[]) {
        Player player1 = new Player("Bi", "5715310062");
        Player player2 = new Player("AToan", "5715310062");
        Player player3 = new Player("CAnh", "5715310062");
        ArrayList<Player> players=new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        BlackJackGameDriver driver=new BlackJackGameDriver(players);
        driver.dealCards();
        System.out.println("----------------------");
        System.out.println(driver.getRemainingCardCount());
        System.out.println("----------------------");
        System.out.println("Hey "+player1.getName()+". Wanna hit? "+driver.wantsToHit(player1));
        if (driver.wantsToHit(player1)){
            driver.hit(player1);
        }
        System.out.println("Hey "+player2.getName()+". Wanna hit? "+driver.wantsToHit(player2));
        if (driver.wantsToHit(player2)){
            driver.hit(player2);
        }
        System.out.println("Hey "+player3.getName()+". Wanna hit? "+driver.wantsToHit(player3));
        if (driver.wantsToHit(player3)){
            driver.hit(player3);
        }
        /*
        System.out.println("----------------------");
        System.out.println("Who wins?");
        if (player1.playerHand.compareTo(player2.playerHand) > 0) {
            System.out.println("The winner is: " + player1.getName());
        }
        else if (player1.playerHand.compareTo(player2.playerHand) < 0) {
            System.out.println("The winner is: " + player2.getName());
        }
        else{
            System.out.println("Both are good!");
        }
        System.out.println("The number of cards remains in the deck :"+deck.numOfCards);*/
    }
}
