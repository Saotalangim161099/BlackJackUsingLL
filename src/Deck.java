import java.security.SecureRandom;

public class Deck {
    int numOfCards = 0;
    LLCard deck;
    public static final String[] CARD_VALUES = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    public static final String[] CARD_SUITS = new String[]{"H", "S", "D", "C"};
    LLCard head = null;

    /**
     * if empty is true, generate a deck with no card, otherwise, generate a full standard deck
     * @param empty
     */
    public Deck(boolean empty) {
        //original deck has no card
    }


    public void generateStandardDeck() {
        for (int i = 0; i < CARD_VALUES.length; i++) {
            for (int j = 0; j < CARD_SUITS.length; j++) {
                LLCard card = new LLCard(CARD_VALUES[i], CARD_SUITS[j], null);
                addCardNode(card);
            }
        }
    }


    //change name & simplify
    public void addCardNode(LLCard newCardNode) {
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

    //Fix, add both addEnd and addFront method
    public void addEnd(LLCard newCardNode) {
        System.out.println(("Add edd"));
        LLCard cursor = head;
        while (cursor.getLink() != null) {
            cursor = cursor.getLink();
            System.out.println("Here");
        }
        cursor.setLink(newCardNode);
    }

    public LLCard removeAtIndex(int index) {
        System.out.println("Removing cardd at " + index);
        if (index > numOfCards) {
            return null;
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            LLCard tempHead = head;
            head = head.getLink();
            numOfCards--;
            return tempHead;
        } else {
            LLCard cursor = null;
            LLCard next = head;
            for (int i = 0; i < index; i++) {
                cursor = next;
                next = next.getLink();
            }
            LLCard nextOfNext = next.getLink();
            LLCard removedNode = next;
            cursor.setLink(nextOfNext);
            numOfCards--;
            return removedNode;
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
            addEnd(deletedCardNode); // change to addFront
        }
    }

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

