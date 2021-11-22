public class Deck {
    LLCards deck;
    public static final String[] CARD_VALUES = new String[]{"1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    public static final String[] CARD_SUITS = new String[]{"H", "S", "D", "C"};

    public Deck() {
        deck = new LLCards();
        generateDeck();
    }

    public void generateDeck() {
        for (int i = 0; i < CARD_VALUES.length; i++) {
            for (int j = 0; j < CARD_SUITS.length; j++) {
                Cardd card = new Cardd(CARD_VALUES[i], CARD_SUITS[j]);
                deck.addCardNode(card);

            }
        }
    }

    public int size() {
        return deck.size();
    }

    public LLCards getDeck() {
        return deck;
    }

    public void setDeck(LLCards deck) {
        this.deck = deck;
    }

    public void printDeck() {
        deck.printCards();
    }
}
