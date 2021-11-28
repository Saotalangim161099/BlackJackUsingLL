public class Player {
    //name
    //phone number
    //CardHand
    String name;
    String phoneNumber;
    CardHand playerHand;

    public Player(String name, String phoneNumber) {
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

    public CardHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(CardHand playerHand) {
        this.playerHand = playerHand;
    }

    //Doing there
    public int getPoint(){
        return -1;
    }

    //adding more right there
    public String toString(){
        return name+", "+phoneNumber;
    }
}
