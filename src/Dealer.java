public class Dealer{
    CardHand dealerHand=new CardHand(false);
    public boolean isBusted() {
        if (dealerHand.getTotalPoint() > 21) {
            return true;
        }
        return false;
    }

    public boolean isBlackJack() {
        if ((dealerHand.size() == 2) && dealerHand.getTotalPoint() == 21) {
            return true;
        }
        return false;
    }
}
