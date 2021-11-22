public class LLCards {
    LLNode head;
    int numOfCards;

    public LLCards() {
        this.head = null;
        numOfCards = 0;
    }

    public void addCardNode(Cardd newCard) {
        LLNode newCardNode = new LLNode(newCard, null);
        if (head == null) {
            head = newCardNode;
            numOfCards++;
            return;
        } else {
            LLNode cursor = head;
            if (cursor.isSmallerValue(newCard)==false) {
                newCardNode.setLink(cursor);
                head = newCardNode;
                numOfCards++;
                return;
            }
            while (cursor != null) {
                LLNode next = cursor.getLink();
                if (next == null) {
                    cursor.setLink(newCardNode);
                    numOfCards++;
                    return;
                } else if (next.isSmallerValue(newCard)==false) {
                    cursor.setLink(newCardNode);
                    newCardNode.setLink(next);
                    return;
                }
                cursor = cursor.getLink();
            }
        }

    }

    public void addEnd(Cardd newCard){
        LLNode newCardNode=new LLNode(newCard,null);
        LLNode cursor=head;
        while (cursor.getLink()!=null){
            cursor=cursor.getLink();
        }
        cursor.setLink(newCardNode);
    }

    public Cardd removeAtIndex(int index) {
        if (index > numOfCards) {
            return null;
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            LLNode tempHead=head;
            head = head.getLink();
            numOfCards--;
            return tempHead.getData();
        } else {
            LLNode cursor = null;
            LLNode next = head;
            for (int i = 0; i < index; i++) {
                cursor = next;
                next = next.getLink();
            }
            LLNode nextOfNext = next.getLink();
            LLNode removedNode = next;
            cursor.setLink(nextOfNext);
            numOfCards--;
            return removedNode.getData();
        }

    }

    public void shuffle() { //ASSUMPTION: Each shuffle includes 4 times(the most)
        for(int i=0;i<3;i++) {
            int rand = (int) (Math.random() * 100) % numOfCards;
            Cardd deletedCard = removeAtIndex(rand);
            addEnd(deletedCard);
        }
    }

    public int size() {
        return numOfCards;
    }


    public void printCards() {
        if (head == null) {
            return;
        }
        LLNode cursor = head;
        while (cursor != null) {
            System.out.println(cursor.getData().toString());
            cursor = cursor.getLink();
        }
    }


}

