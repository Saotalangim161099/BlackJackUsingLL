import java.util.ArrayList;
import java.util.Arrays;

public class BlackJackGameDriver {
    ArrayList<Player> players;
    int turnIndex;
    Deck bJDeck;

    public BlackJackGameDriver(ArrayList<Player> players) {
        this.players = players;
        bJDeck = new Deck(false);
        turnIndex = 0;
    }

    public void dealCards() {
        for (Player player : players) {
            System.out.println("Dealing cards for " + player.getName());
            bJDeck.dealCards(player);
            System.out.println(player.getName() + "'s hand is ");
            player.playerHand.printCards();
            System.out.println("----------------------");
        }
    }

    public int getRemainingCardCount(){
        return bJDeck.numOfCards;
    }

    /*
    Process the command for current player. Those are the possible commands:
    hit - add a card to current player's hand
    stand - proceed to next player (turnIndex + 1)
    * if score exceed 21 (busted), stop current player's turn and skip to next one

    public void processTurn(String name,String command) {

    }*/

    public String toString() {
        return players.toString();
    }

}
