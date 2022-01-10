import java.util.ArrayList;

public class CardHand implements Comparable {
    public static final int BLACKJACK_VALUE = 999999;
    public static final int BUSTED_VALUE = -1;
    ArrayList<LLCard> cardHand;


    /**
     * if empty is true, generate a deck with no card, otherwise, generate a full standard deck
     *
     * @param
     */
    public CardHand() {
        cardHand = new ArrayList<>();
    }

    /**
     * @return
     */
    public int getValue() {
        if (isBlackJack()) {
            return BLACKJACK_VALUE;
        }
        else if (isBusted()) {
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
        if ((cardHand.size() == 2) && getTotalPoint() == 21) {
            return true;
        }
        return false;
    }

    public int getTotalPoint() {
        int totalPoint = 0;
        int non_aces_sum = 0;
        int numOfAce = 0;
        for (LLCard card : cardHand) {
            if (card.getCardValue() == 1) {
                numOfAce++;
            } else {
                non_aces_sum += card.getCardValue();
            }
            card = card.getLink();
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

        return totalPoint;
    }

    public void presentCardHand(){
        for (int i=0;i<cardHand.size();i++){
            System.out.println(cardHand.get(i).getCard());
        }
    }

    public void addCard(LLCard card){
        cardHand.add(card);
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
