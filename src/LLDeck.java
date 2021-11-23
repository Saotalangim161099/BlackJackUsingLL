public class LLDeck {
    int numOfCards=0;
    LLCard deck;
    public static final String[] CARD_VALUES = new String[]{"1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    public static final String[] CARD_SUITS = new String[]{"H", "S", "D", "C"};
    LLCard head=null;

    public LLDeck() {
        generateDeck();
    }

    public void generateDeck() {
        for (int i = 0; i < CARD_VALUES.length; i++) {
            for (int j = 0; j < CARD_SUITS.length; j++) {
                LLCard card = new LLCard(CARD_VALUES[i], CARD_SUITS[j],null);
                addCardNode(card);
            }
        }
    }



    public void addCardNode(LLCard newCardNode) {
        if (head == null) {
            head = newCardNode;
            numOfCards++;
            return;
        } else {
            LLCard cursor = head;
            if (cursor.isSmallerValue(newCardNode)==false) {
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
                } else if (next.isSmallerValue(newCardNode)==false) {
                    cursor.setLink(newCardNode);
                    newCardNode.setLink(next);
                    return;
                }
                cursor = cursor.getLink();
            }
        }

    }

    public void addEnd(LLCard newCardNode){
        LLCard cursor=head;
        while (cursor.getLink()!=null){
            cursor=cursor.getLink();
        }
        cursor.setLink(newCardNode);
    }

    public LLCard removeAtIndex(int index) {
        if (index > numOfCards) {
            return null;
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            LLCard tempHead=head;
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

    public void shuffle() { //ASSUMPTION: Each shuffle includes 4 times(the most)
        for(int i=0;i<3;i++) {
            int rand = (int) (Math.random() * 100) % numOfCards;
            LLCard deletedCardNode = removeAtIndex(rand);
            addEnd(deletedCardNode);
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

