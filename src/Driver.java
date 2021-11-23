public class Driver {
    public static void main(String args[]) {
        Deck deck = new Deck(false);
        System.out.println("Number of cards: "+ deck.numOfCards);
        deck.printCards();
        System.out.println("Shuffling 1");
        deck.shuffle();
        deck.printCards();
        //System.out.println(deck.numOfCards);

        /*LLClass c=new LLClass();

        LLNode s1=new LLNode("B",null);
        c.addLast(s1);
        c.printCards();
        System.out.println("------------");
        LLNode s2=new LLNode("F",null);
        c.addLast(s2);
        c.printCards();
        System.out.println("------------");
        LLNode s3=new LLNode("E",null);
        c.addLast(s3);
        c.printCards();
        System.out.println("------------");
        LLNode s4=new LLNode("P",null);
        c.addLast(s4);
        c.printCards();
        System.out.println("------------");*/



    }
}
