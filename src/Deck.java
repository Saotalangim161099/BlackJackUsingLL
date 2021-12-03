import java.security.SecureRandom;

public class Deck {
    int numOfCards = 0;
    LLCard deck;
    public static final String[] CARD_VALUES = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    public static final String[] CARD_SUITS = new String[]{"H", "S", "D", "C"};
    LLCard head = null;

    /**
     * if empty is true, generate a deck with no card, otherwise, generate a full standard deck
     *
     * @param empty
     */
    public Deck(boolean empty) {
        //original deck has no card
        if (empty == true) {
            return;
        } else {
            generateStandardDeck();
        }
    }


    public void generateStandardDeck() {
        for (int i = 0; i < CARD_VALUES.length; i++) {
            for (int j = 0; j < CARD_SUITS.length; j++) {
                LLCard card = new LLCard(CARD_VALUES[i], CARD_SUITS[j], null);
                addFront(card);
            }
        }
    }

    public void addFront(LLCard newCard) {
        if (head == null) {
            head = newCard;
            numOfCards++;
            return;
        } else {
            newCard.setLink(head);
            head = newCard;
            numOfCards++;
            return;
        }
    }

    //change name & simplify
    public void addCardInOrder(LLCard newCardNode) {
        if (head == null) {
            head = newCardNode;
            numOfCards++;
            return;
        } else {
            LLCard cursor = head;
            if (cursor.isSmallerValue(newCardNode) == false) {
                newCardNode.setLink(cursor);
                head = newCardNode;
                numOfCards++;
                return;
            }
            while (cursor != null) {
                LLCard next = cursor.getLink();
                if (next == null) {
                    cursor.setLink(newCardNode);
                    numOfCards++;
                    return;
                } else if (next.isSmallerValue(newCardNode) == false) {
                    cursor.setLink(newCardNode);
                    newCardNode.setLink(next);
                    return;
                }
                cursor = cursor.getLink();
            }
        }

    }

    public LLCard removeFirst() {
        if (head == null) {
            System.out.println("Deck is empty");
            return null;
        } else if (head.getLink() == null) {
            numOfCards--;
            return head;
        } else {
            LLCard firstNode=head;
            head=head.getLink();
            firstNode.setLink(null);
            numOfCards--;
            return firstNode;
        }
    }


    public LLCard removeAtIndex(int index) {
        //System.out.println("Removing card at " + index);
        if (head == null) {
            //System.out.println("Deck is empty");
            return null;
        }
        LLCard cursor = head;
        if (index == 0) {
            LLCard temp = head;
            head = head.getLink();
            temp.setLink(null);
            numOfCards--;
            return temp;
        }

        for (int i = 0; cursor != null && i < index - 1; i++) {
            cursor = cursor.getLink();
        }
        if (cursor == null || cursor.getLink() == null) {

            return null;
        }
        LLCard nextOfNext = cursor.getLink().getLink();
        LLCard removedNode = cursor.getLink();
        removedNode.setLink(null);
        cursor.setLink(nextOfNext);
        numOfCards--;
        return removedNode;
    }

    //Fix, add both addEnd and addFront method
    public void addLast(LLCard newCardNode) {
        if (head == null) {
            head = newCardNode;
            numOfCards++;
            return;
        } else if (head.getLink() == null) {
            head.setLink(newCardNode);
            numOfCards++;
            return;
        } else {
            LLCard cursor = head;

            while (cursor.getLink() != null) {
                //System.out.println(cursor.getCard());
                //System.out.println("*******");
                cursor = cursor.getLink();
            }
            cursor.setLink(newCardNode);
            numOfCards++;
        }
    }

    /**
     * Remove a card at random index
     * Add to the front
     */
    public void shuffle() { //ASSUMPTION: Each shuffle includes 4 times(the most)
        for (int i = 0; i < 1000; i++) {
            SecureRandom random = new SecureRandom();
            int rand = Math.abs(random.nextInt()) % numOfCards;
            LLCard deletedCardNode = removeAtIndex(rand);
            addLast(deletedCardNode); // change to addFront
            //System.out.println("Done!!!!!!!");

        }
    }

    /*public void dealCards(Player player){
        shuffle();
        LLCard removedCard1=removeFirst();
        player.playerHand.add(removedCard1);
        LLCard removedCard2=removeFirst();
        player.playerHand.addFront(removedCard2);
    }

    public void hitCard(Player player){
        shuffle();
        LLCard removedCard1=removeFirst();
        player.playerHand.addFront(removedCard1);
        player.playerHand.printCards();
    }*/

    public int size() {
        return numOfCards;
    }


    public void printCards() {
        if (head == null) {
            return;
        }
        LLCard cursor = head;
        while (cursor != null) {
            System.out.println(cursor.getCard());
            cursor = cursor.getLink();
        }
    }


}

