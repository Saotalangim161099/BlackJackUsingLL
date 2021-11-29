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

    public void dealerControl(Deck deck){
        while (dealerHand.getTotalPoint()<=16){
            System.out.println("Dealer has "+dealerHand.getTotalPoint()+" and hits.");
            dealerHand.addFront(deck.removeFirst()); //use the blackJack deck in the BlackJackGameDriver
            System.out.println("Now dealer's cards: ");
            dealerHand.printCards();
        }
        if (dealerHand.getTotalPoint()>21){
            System.out.println("Dealer busts! ");
            dealerHand.printCards();
        }
        else{
            System.out.println("Dealer stands! ");
            dealerHand.printCards();
        }
    }

    public void addFront(LLCard card){
        dealerHand.addFront(card);
    }

    public int getTotalPoint(){
        return dealerHand.getTotalPoint();
    }
}
