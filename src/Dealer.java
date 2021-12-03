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

    public void dealerControl(Deck deck) {
        while (dealerHand.getTotalPoint() <= 16) {
            System.out.println("Dealer has " + dealerHand.getTotalPoint() + " and hits.");
            dealerHand.addCard(deck.removeFirst()); //use the blackJack deck in the BlackJackGameDriver
            System.out.println("Now dealer's cards: ");
            dealerHand.presentCardHand();
        }
        if (dealerHand.getTotalPoint() > 21) {
            System.out.println("Dealer busts! ");
            dealerHand.presentCardHand();
        } else {
            System.out.println("Dealer stands! ");
            dealerHand.presentCardHand();
        }
    }

    public void addFront(LLCard card) {
        dealerHand.addCard(card);
    }

    public int getTotalPointDealerHand() {
        return dealerHand.getTotalPoint();
    }
}
