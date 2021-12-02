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
    Dealer dealer=new Dealer();

    public BlackJackGameDriver() {
        bJDeck = new Deck(false);
        turnIndex = 0;
        players=new ArrayList<>();

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
            Player player=new Player(name, phoneNumber);
            players.add(player);
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
            dealer.addFront(bJDeck.removeFirst());
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

    public void hitOrStand(){
        String command;
        char choice;
        for (int i=0;i<numOfPlayers;i++){
            if ((players.get(i).getBet()>0)&&(wantsToHit(players.get(i))==true)){
                do{
                    do{
                        System.out.println("Hit or stand?");
                        command=sc.next();
                        choice=command.toUpperCase().charAt(0);
                    } while ((choice!='H'&&choice!='S'));
                    if (choice=='H'){
                        bJDeck.hitCard(players.get(i));
                        System.out.println("Now "+players.get(i)+" has: ");
                        players.get(i).playerHand.printCards();
                    }
                } while (choice!='S'&&players.get(i).playerHand.getTotalPoint()<=21);
            }
        }
    }

    //dealer plays
    public void dealerPlays(){
        boolean areAllPlayersDone=true;
        for (int i=0;i<numOfPlayers&&areAllPlayersDone==true;i++){
            if (players.get(i).getBet()>0&&players.get(i).playerHand.getTotalPoint()<=21){
                areAllPlayersDone=false;
            }
        }
        if (areAllPlayersDone==true){
            dealer.dealerControl(bJDeck);
        }
    }

    //Consider all possible outcomes and adds or removes the players'bets
    public void controlGame(){
        for (int i=0;i<numOfPlayers;i++){
            if (players.get(i).getBet()>0){
                if (players.get(i).getTotalPointPlayerHand()>21){
                    System.out.println(players.get(i).getName()+" has busted!");
                    players.get(i).loseBet();
                    //players.get(i).bust()
                }
                //else if (players.get(i).getTotalPointPlayerHand()== dealer.getTotalPointDealerHand()){
                else if (players.get(i).getTotalPointPlayerHand()<dealer.getTotalPointDealerHand()&&dealer.getTotalPointDealerHand()<=21){
                    System.out.println(players.get(i).getName()+"have lost!");
                    players.get(i).loseBet();
                }
                else{
                    System.out.println(players.get(i).getName()+"have won!");
                    players.get(i).winBet();
                }
            }
        }
    }

    //print status
    public void printStatus(){
        for (int i=0;i<numOfPlayers;i++){
            if (players.get(i).getBank()>0){
                System.out.println(players.get(i).getName()+" has ");
                players.get(i).playerHand.printCards();
            }
        }
        System.out.println("Dealer has ");
        dealer.dealerHand.printCards();
    }

    //print bank
    public void printMoney(){
        for (int i=0;i<numOfPlayers;i++){
            if (players.get(i).getBank()>0){
                System.out.println(players.get(i).getName()+" has "+players.get(i).getBank());
            }
            else if (players.get(i).getBank()==0){
                System.out.println(players.get(i).getName()+" has "+players.get(i).getBank() + ", and is kicked out of the game!!");
            }
        }
    }



}
