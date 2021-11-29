import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackGameDriver {
    ArrayList<Player> players;
    int turnIndex;
    int numOfPlayers;
    String name, phoneNumber;
    Deck bJDeck;
    Scanner sc = new Scanner(System.in);

    public BlackJackGameDriver(ArrayList<Player> players) {
        this.players = players;
        bJDeck = new Deck(false);
        turnIndex = 0;

        //Introduction context
        String names;
        System.out.println("******************** WELCOME TO BLACKJACK!********************");
        System.out.println();
        System.out.println("  BLACKJACK RULES: ");
        System.out.println("	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
        System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
        System.out.println("	-The players cards are added up for their total.");
        System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
        System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
        System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
        System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends.");
        System.out.println("	-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
        System.out.println("");
        System.out.println("");

        //get the number of players, continue until get a valid input from the user
        do {
            System.out.println("How many people are playing (1-6)? ");
            numOfPlayers = sc.nextInt();
        } while (numOfPlayers > 6 || numOfPlayers < 0);

        //get names of the players and assign them to the list of players
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("What is player " + (i + 1) + "'s name? ");
            name = sc.next();
            System.out.println("What is player " + (i + 1) + "'s phone number? ");
            phoneNumber = sc.next();
            players.add(new Player(name, phoneNumber));
        }
    }

    //Shuffle the deck
    public void shuffle() {
        bJDeck.shuffle();
    }

    //Get the bets from the players
    public void getBets() {
        int betValue;

        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).getBank() > 0) {
                do {
                    System.out.println("How much do you want to bet now, " + players.get(i).getName() + " (1- " + players.get(i).getBank() + ")?");
                    betValue = sc.nextInt();
                    players.get(i).setBet(betValue);
                } while ((betValue < 0) || (betValue > players.get(i).getBank()));
            }
        }
    }

    //Deals 2 cards for each player and the dealer
    public void dealCards() {
        bJDeck.shuffle();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numOfPlayers; j++) {
                if (players.get(j).getBank()>0){
                    players.get(j).playerHand.addFront(bJDeck.removeFirst());
                }
            }
        }
    }

    public boolean wantsToHit(Player player) {
        if (player.playerHand.getTotalPoint() < 17) {
            return true;
        }
        return false;
    }

    public void hit(Player player) {
        bJDeck.hitCard(player);
    }

    public int getRemainingCardCount() {
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
