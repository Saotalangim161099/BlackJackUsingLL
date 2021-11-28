public class CardHand extends Deck implements Comparable {
    private static final int BLACKJACK_VALUE = 999999;
    private static final int BUSTED_VALUE = -1;
    LLCard cardHand;


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
            return getTotalPoint();
        }
    }

    public boolean isBusted() {
        if (getTotalPoint() > 21) {
            return true;
        }
        return false;
    }

    public boolean isBlackJack() {
       if ((size()==2)&&getTotalPoint()==21){
           return true;
       }
       return false;
    }


    public int getTotalPoint() {
        int totalPoint = 0;
        int non_aces_sum=0;
        int numOfAce=0;
        if (head == null) {
            totalPoint = 0;
        } else if (head.getLink() == null) {
            totalPoint = head.getCardValue();
            if (head.getCardValue()==1){
                totalPoint+=10;
            }
        } else {
            LLCard cursor = head;
            while (cursor != null) {
                if (cursor.getCardValue() == 1) {
                    numOfAce++;
                }
                else{
                    non_aces_sum += cursor.getCardValue();
                }
                cursor = cursor.getLink();
            }
            int aces_sum = 0;
            if (numOfAce > 0) {
                aces_sum = 11;
            }
            for (int i = 0; i < numOfAce - 1; i++) {  //already assign 1 ace value of 1
                aces_sum += 1;
            }
            if (aces_sum + non_aces_sum > 21) {
                aces_sum = numOfAce;
            }
            totalPoint = non_aces_sum + aces_sum;
        }
        return totalPoint;
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
