public class Dealer {
    CardHand dealerHand = new CardHand();

    public boolean isBusted() {
        if (dealerHand.getTotalPoint() > 21) {
            return true;
        }
        return false;
    }

    /*public boolean isBlackJack() {
        if ((dealerHand.size() == 2) && dealerHand.getTotalPoint() == 21) {
            return true;
        }
        return false;
    }*/



    public void addFront(LLCard card) {
        dealerHand.addCard(card);
    }

    public int getTotalPointDealerHand() {
        return dealerHand.getTotalPoint();
    }
}
