public class LLCards{
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
            return;
        } else {
            LLNode cursor = head;
            if (cursor.isSmallerValue(newCard)) {
                newCardNode.setLink(cursor);
                head = newCardNode;
                return;
            }
            while (cursor != null) {
                LLNode next = cursor.getLink();
                if (next == null) {
                    cursor.setLink(newCardNode);
                    return;
                } else if (next.isSmallerValue(newCard)) {
                    LLNode tempNext = next;
                    cursor.setLink(newCardNode);
                    newCardNode.setLink(tempNext);
                }
                cursor = cursor.getLink();
            }
        }
        numOfCards++;
    }
    //LLNode nextHead = head.getLink();
    //LLNode next = head.getLink();
            /*if (nextHead == null) {
                if (cursor.isSmallerValue(newCard)) {
                    newCardNode.setLink(cursor);
                    head = newCardNode;
                    System.out.println("Check!!!!");
                    return;
                } else {
                    head.setLink(newCardNode);
                    System.out.println("Check!!!!");
                }
                System.out.println("Check!!!!");
            }
            else if (next)
            while (cursor != null) {
                LLNode next = cursor.getLink();
                if (next.isSmallerValue(newCard)) {
                    LLNode tempNext = next;
                    newCardNode.setLink(tempNext);
                    cursor.setLink(newCardNode);
                    break;
                } else {
                    next.setLink(newCardNode);

                }
                cursor = cursor.getLink();
            }*/


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

