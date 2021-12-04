import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGameDriver {
    ArrayList<Player> players;
    int turnIndex;
    int numOfPlayers;
    Deck BJDeck;
    Scanner sc = new Scanner(System.in);
    Dealer dealer = new Dealer();
    private boolean gameFinished;

    public void initGame(ArrayList<Player> players, int deckCount) {
        turnIndex = 0;
        showIntro();
        this.players = players;
        initPlayers(players);
        initDeck(); //deckCount will be used later to create blackjack deck with multiple decks
        BJDeck.shuffle();
        gameFinished = false;
        dealStartingCards();
        checkBlackJack();

    }

    //If any player has BlackJack, he/she will be the winner, then terminates the game
    public boolean checkBlackJack(){
        for (Player player:players){
            if (player.playerHand.isBlackJack()){
                gameFinished=true;
                System.out.println("Player "+player.getName()+" has BlackJack!!!!");
                System.out.println("The winner is "+player.getName());
            }
        }
        return false;
    }

    //compare multiple players points, will return LIST of winners
    public ArrayList<Player> compareMultiple(){
        ArrayList<Integer> points=new ArrayList<>();
        ArrayList<Player> winners=new ArrayList<>();
        Player maxValuePlayer=players.get(0);

        int maxValue=players.get(0).playerHand.getValue();
        for (Player player:players){
            if (player.playerHand.getValue()>maxValue){
                maxValue=player.playerHand.getValue();
                maxValuePlayer=player;
                winners.clear();
                winners.add(player);
            }
            else if (player.playerHand.getValue()==maxValue){
                winners.add(player);
            }
        }
        return winners;

    }

    //determine max points among list of players' points
    public int maxPoint(ArrayList<Integer> list){
        int max=list.get(0);
        for (int i=1;i< list.size();i++){
            if (list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }



    public void initPlayers(ArrayList<Player> players) {
        this.players = players;

    }

    public void initDeck() {
        BJDeck = new Deck(false);
    }

    public boolean isGameFinished() {
        return gameFinished;
    }


    public void showIntro() {
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
        System.out.println("***************************************************************");

    }

    public void dealStartingCards() {
        for (Player player : players) {
            System.out.println(player.getName());
            dealCard(player);
            dealCard(player);
            player.printPlayerHand();
            System.out.println("Current total point: " + player.getTotalPointPlayerHand());

        }
    }


    public void processMove(Move move) {
        if (move.getPhoneNumber().equals(players.get(turnIndex).getPhoneNumber())) {
            System.out.println("Player having phone number: "+move.getPhoneNumber()+ " want to " + move.getMove());
            System.out.println("Total point: "+players.get(turnIndex).getTotalPointPlayerHand());
            if (move.getMove().toLowerCase().equals("stand")) {
                turnIndex++;
            } else if (move.getMove().toLowerCase().equals("hit")) {
                dealCard(players.get(turnIndex));
                System.out.println(players.get(turnIndex).getName() + "'s card hand: ");
                players.get(turnIndex).printPlayerHand();
                System.out.println("Point: " + players.get(turnIndex).playerHand.getTotalPoint());
            }

            if (turnIndex == players.size()) {
                //calculate point, decide winner, flip isGameFinish to True
                System.out.println("BlackJack Game is over! Now it's time to know the winner!!!");
                gameFinished=true;
                determineWinnerMultiple();

            }
            //process player's move
        } else {
            System.out.println("It's not Player having phone number: "+move.getPhoneNumber() + "'s turn");
        }
    }

    //calculate total points of 2 players and then determine the winner
    public void determineWinnerOverTwo() {

        int result = players.get(0).playerHand.compareTo(players.get(1).playerHand);
        System.out.println(players.get(0).getName() + "'s total point: " + players.get(0).getTotalPointPlayerHand());
        if (players.get(0).playerHand.isBusted()) {
            System.out.println("You are busted!!!!!");
        }
        System.out.println(players.get(1).getName() + "'s total point: " + players.get(1).getTotalPointPlayerHand());
        if (players.get(1).playerHand.isBusted()) {
            System.out.println("You are busted!!!!!");
        }
        if (result == 0) {
            System.out.println("Both are busted!");
        } else if (result == 1) {
            System.out.println("Congratulations! The winner is " + players.get(0).getName());
        } else {
            System.out.println("Congratulations! The winner is " + players.get(1).getName());
        }
        gameFinished = true;
    }

    //determine winner over multiple players
    public void determineWinnerMultiple(){
        for (Player player:players){
            System.out.println(player.getName() + "'s total point: " + player.getTotalPointPlayerHand());
        }
        ArrayList<Player> winners=compareMultiple();
        System.out.println("Winner(s): ");
        for (Player winner:winners){
            System.out.println(winner.getName());
        }
    }

    //Shuffle the deck
    public void shuffle() {
        BJDeck.shuffle();
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

    public void dealCard(Player player) {
        player.playerHand.addCard(BJDeck.removeFirst());
    }

    //Deals 2 cards for each player and the dealer
    public void dealCards() {
        BJDeck.shuffle();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numOfPlayers; j++) {
                if (players.get(j).getBank() > 0) {
                    players.get(j).playerHand.addCard(BJDeck.removeFirst());
                }
            }
            dealer.addFront(BJDeck.removeFirst());
        }
    }

    public boolean wantsToHit(Player player) {
        if (player.playerHand.getTotalPoint() < 17) {
            return true;
        }
        return false;
    }


    public int getRemainingCardCount() {
        return BJDeck.numOfCards;
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

    /*public void hitOrStand() {
        String command;
        char choice;
        for (int i = 0; i < numOfPlayers; i++) {
            if ((players.get(i).getBet() > 0) && (wantsToHit(players.get(i)) == true)) {
                do {
                    do {
                        System.out.println("Hit or stand?");
                        command = sc.next();
                        choice = command.toUpperCase().charAt(0);
                    } while ((choice != 'H' && choice != 'S'));
                    if (choice == 'H') {
                        BJDeck.hitCard(players.get(i));
                        System.out.println("Now " + players.get(i) + " has: ");
                        players.get(i).playerHand.printCards();
                    }
                } while (choice != 'S' && players.get(i).playerHand.getTotalPoint() <= 21);
            }
        }
    }*/

    //dealer plays
    public void dealerPlays() {
        boolean areAllPlayersDone = true;
        for (int i = 0; i < numOfPlayers && areAllPlayersDone == true; i++) {
            if (players.get(i).getBet() > 0 && players.get(i).playerHand.getTotalPoint() <= 21) {
                areAllPlayersDone = false;
            }
        }
        if (areAllPlayersDone == true) {
            dealer.dealerControl(BJDeck);
        }
    }

    //Consider all possible outcomes and adds or removes the players'bets
   /* public void controlGame() {
        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).getBet() > 0) {
                if (players.get(i).playerHand.getTotalPointPlayerHand() > 21) {
                    System.out.println(players.get(i).getName() + " has busted!");
                    players.get(i).loseBet();
                    //players.get(i).bust()
                }
                //else if (players.get(i).getTotalPointPlayerHand()== dealer.getTotalPointDealerHand()){
                else if (players.get(i).getTotalPointPlayerHand() < dealer.getTotalPointDealerHand() && dealer.getTotalPointDealerHand() <= 21) {
                    System.out.println(players.get(i).getName() + "have lost!");
                    players.get(i).loseBet();
                } else {
                    System.out.println(players.get(i).getName() + "have won!");
                    players.get(i).winBet();
                }
            }
        }
    }*/

    //print status
    public void printStatus() {
        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).getBank() > 0) {
                System.out.println(players.get(i).getName() + " has ");
                players.get(i).playerHand.presentCardHand();
            }
        }
        System.out.println("Dealer has ");
        dealer.dealerHand.presentCardHand();
    }

    //print bank
    public void printMoney() {
        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).getBank() > 0) {
                System.out.println(players.get(i).getName() + " has " + players.get(i).getBank());
            } else if (players.get(i).getBank() == 0) {
                System.out.println(players.get(i).getName() + " has " + players.get(i).getBank() + ", and is kicked out of the game!!");
            }
        }
    }


}
