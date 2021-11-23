public class LLCard {
    String value;
    String suit;
    int numOfCards;
    LLCard link;

    public LLCard(String value, String suit, LLCard link) {
        this.value = value;
        this.suit = suit;
        this.link = link;
    }

    public String getCard(){
        switch (suit) {
            case "H":
                switch (value) {
                    case "1":
                        return "A-H";
                    case "11":
                        return "J-H";
                    case "12":
                        return "K-H";
                    case "13":
                        return "Q-H";
                    default:
                        return value + "-H";
                }
            case "S":
                switch (value) {
                    case "1":
                        return "A-S";
                    case "11":
                        return "J-S";
                    case "12":
                        return "K-S";
                    case "13":
                        return "Q-S";
                    default:
                        return value + "-S";
                }
            case "D":
                switch (value) {
                    case "1":
                        return "A-D";
                    case "11":
                        return "J-D";
                    case "12":
                        return "K-D";
                    case "13":
                        return "Q-D";
                    default:
                        return value + "-D";
                }
            case "C":
                switch (value) {
                    case "1":
                        return "A-C";
                    case "11":
                        return "J-C";
                    case "12":
                        return "K-C";
                    case "13":
                        return "Q-C";
                    default:
                        return value + "-C";
                }
        }
        return null;
    }

    public void setCard(String value, String suit){
        this.value=value;
        this.suit=suit;
    }

    public LLCard getLink() {
        return link;
    }

    public void setLink(LLCard link) {
        this.link = link;
    }

    public boolean isSmallerValue(LLCard card) { //Node value<card value
        return Integer.parseInt(this.value) < Integer.parseInt(card.value);
    }
}
