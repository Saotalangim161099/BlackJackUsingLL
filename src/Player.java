public class Player {
    //name
    //phone number
    //CardHand
    String name;
    String phoneNumber;
    int bank;
    int bet;
    CardHand playerHand;

    public Player(String name, String phoneNumber) {
        this.bank = 100; //Initially each player will be offered 100 coins
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.playerHand = new CardHand(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    //get total points of player hand
    public int getTotalPointPlayerHand() {
        return playerHand.getTotalPoint();
    }

    public CardHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(CardHand playerHand) {
        this.playerHand = playerHand;
    }

    //Doing there
    public int getPoint() {
        return -1;
    }

    //Removes the player's bet amount from their bank if they bust. Then sets his bet to 0
    public void loseBet() {
        bank -= bet;
        bet = 0;
    }

    //Otherwise adds the player's bank the amount they bet. Also set bet to 0
    public void winBet() {
        bank += bet;
        bet = 0;
    }

    //reset the removed player's bank to 0
    public void resetBank() {
        bank = 0;
    }


    //Clears the player's hand card

    //adding more right there
    public String toString() {
        return name + " - " + phoneNumber;
    }

}
