public class Player {

    private String name;
    private String phoneNumber;
    private CardHand playerHand;

    private int status;

    public static final int STATUS_WIN = 1;
    public static final int STATUS_TIE = 0;
    public static final int STATUS_LOSE = -1;
    public static final int STATUS_UNDETERMINED = 9;

    public Player(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.playerHand = new CardHand();
        status = STATUS_UNDETERMINED;
    }

    public void addCard(LLCard card) {
        playerHand.addCard(card);
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //get total points of player hand
    public int getHandValue() {
        return playerHand.getValue();
    }

    public CardHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(CardHand playerHand) {
        this.playerHand = playerHand;
    }

    public String toString() {
        return name + " - " + phoneNumber;
    }

    public void printHand() {
        playerHand.presentCardHand();
    }

}
