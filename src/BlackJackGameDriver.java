import java.util.ArrayList;

public class BlackJackGameDriver {
    private ArrayList<Player> players;
    private int turnIndex;
    private int numOfPlayers;
    private Deck BJDeck;
    private Dealer dealer = new Dealer();
    private boolean gameFinished;


    public void initGame(ArrayList<Player> players, int deckCount) {
        turnIndex = 0;
        this.players = players;
        initPlayers(players);
        initDeck(); //deckCount will be used later to create blackjack deck with multiple decks
        BJDeck.shuffle();
        gameFinished = false;
        dealStartingCards();
        checkDealerBlackjackCase();
    }

    //If any player has BlackJack, he/she will be the winner, then terminates the game
    public void checkDealerBlackjackCase() {
        if (dealer.dealerHand.isBlackJack()) {
            System.out.println("Dealer has blackjack");
            for (Player player : players) {
                if (player.getHandValue() == CardHand.BLACKJACK_VALUE) {
                    player.setStatus(Player.STATUS_WIN);
                } else {
                    player.setStatus(Player.STATUS_LOSE);
                }
            }
            for (Player player : players) {
                System.out.println(player.getName() + " - " + player.getStatus());
            }
            gameFinished = true;
        }
    }


    //compare multiple players points, will return LIST of winners
    public void initWinners() {

        int dealerValue = dealer.dealerHand.getValue();

        for (Player player : players) {
            if (player.getHandValue() > dealerValue) {
                player.setStatus(Player.STATUS_WIN);
            } else if (player.getHandValue() == dealerValue) {
                player.setStatus(Player.STATUS_TIE);
            } else {
                player.setStatus(Player.STATUS_LOSE);
            }

        }

        for (Player player : players) {
            System.out.println(player.getName() + " - " + player.getStatus());
        }
        gameFinished = true;

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

    public void dealStartingCards() {
        for (Player player : players) {
            System.out.println(player.getName());
            for (int i = 0; i < 2; i++) {
                dealCardForPlayer(player);
            }
            player.printHand();
            System.out.println("Total: " + player.getHandValue());
        }
        dealCardForDealer();
        dealCardForDealer();
        System.out.println("Dealer's hand:");
        dealer.printHand();
        System.out.println("Total: " + dealer.getTotalPointDealerHand());
    }

    //show total points of each player
    public void showPoints() {
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getHandValue());
        }
    }

    //dealer will be automatically played
    public void dealerPlays() {
        while (dealer.dealerHand.getTotalPoint() <= 16) {
            System.out.println("Dealer has " + dealer.getTotalPointDealerHand() + " and hits");
            dealCardForDealer();
        }
        System.out.println("Dealer's point: " + dealer.getTotalPointDealerHand());
    }

    public void processMove(String phoneNumber,String move) {
        Player currentPlayer = players.get(turnIndex);
        if (phoneNumber.equals(currentPlayer.getPhoneNumber())) {
            System.out.println("Player having phone number: " + phoneNumber + " want to " + move);
            System.out.println("Current point: " + currentPlayer.getHandValue());
            if (move.toLowerCase().equals("stand")) {
                turnIndex++;
            } else if (move.toLowerCase().equals("hit")) {
                dealCardForPlayer(currentPlayer);
                System.out.println(currentPlayer.getName() + "'s card hand: ");
                players.get(turnIndex).printHand();
                System.out.println("Point after the move: " + currentPlayer.getHandValue());
                if (currentPlayer.getHandValue() == CardHand.BUSTED_VALUE) {
                    System.out.println("Player " + currentPlayer.getName() + " busted");
                    turnIndex++;
                }
            }

            if (turnIndex == players.size()) {
                dealerPlays();
                System.out.println("BlackJack Game is over! Now it's time to know the winner!!!");
                gameFinished = true;
                dealerPlays();
                showPoints();
                initWinners();
            }
        } else {
            System.out.println("It's not Player having phone number: " + phoneNumber + "'s turn");
        }
    }

    public void dealCardForPlayer(Player player) {
        player.getPlayerHand().addCard(BJDeck.removeFirst());
    }

    public void dealCardForDealer() {
        dealer.dealerHand.addCard(BJDeck.removeFirst());
    }


    public String toString() {
        return players.toString();
    }
}
