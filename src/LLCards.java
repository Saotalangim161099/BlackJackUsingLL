public class LLCards {
    LLNode head;

    public LLCards() {
        this.head = null;
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
                System.out.println("Check!!!!");
                return;
            }
            while (cursor != null) {
                LLNode next = cursor.getLink();
                if (next == null) {
                    cursor.setLink(newCardNode);
                    return;
                } else if (next.isSmallerValue(newCard)) {
                    LLNode tempNext = next;
                    newCardNode.setLink(tempNext);
                    cursor.setLink(newCardNode);
                    return;
                }
                cursor = cursor.getLink();
            }
        }
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

    Cardd card1 = new Cardd("11", "D");
    LLNode node = new LLNode(card1, null);
    Cardd card2 = new Cardd("9", "D");

    public void smaller() {  //card < node value
        System.out.println(node.isSmallerValue(card2));
    }
}

