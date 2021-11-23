public class CardHand extends Deck implements Comparable {
    private static final int BLACKJACK_VALUE = 99999;
    private static final int BUSTED_VALUE = -1;

    /**
     * if empty is true, generate a deck with no card, otherwise, generate a full standard deck
     *
     * @param empty
     */
    public CardHand(boolean empty) {
        super(true);
    }

    /**
     * @return
     */
    public int getValue() {
        if (isBlackJack()) {
            return BLACKJACK_VALUE;
        }
        if (isBusted()) {
            return BUSTED_VALUE;
        } else {
            return 0;
        }
    }

    private boolean isBlackJack() {
        return false;
    }

    private boolean isBusted() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        CardHand opponent = (CardHand) o;
        if (this.getValue() == opponent.getValue()) {
            return 0;
        } else {
            if (this.getValue() > opponent.getValue())
                return 1;
            else
                return -1;
        }
    }
}
