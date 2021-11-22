public class CardsDriver {
    public static void main(String args[]) {
        LLCards llC = new LLCards();
        Cardd c1 = new Cardd("6", "D");
        llC.addCardNode(c1);
        Cardd c2=new Cardd("4","D");
        llC.addCardNode(c2);
        Cardd c4=new Cardd("7","D");
        llC.addCardNode(c4);
        Cardd c5=new Cardd("2","D");
        llC.addCardNode(c5);
        Cardd c6=new Cardd("1","D");
        llC.addCardNode(c6);
        Cardd c7=new Cardd("8","D");
        llC.addCardNode(c7);
        llC.printCards();
        System.out.println(llC.numOfCards);
        System.out.println("----------------");
        System.out.println("After shuffling: ");
        llC.shuffle();
        llC.printCards();
        //System.out.println("After removing index: ");
        /*llC.removeAtIndex(2);
        System.out.println(llC.numOfCards);
        llC.removeAtIndex(2);
        System.out.println(llC.numOfCards);
        llC.removeAtIndex(2);
        System.out.println(llC.numOfCards);
        llC.printCards();
        //Deck newDeck=new Deck();
        //newDeck.printDeck();*/

        System.out.println("The crazy: ");
        int rand = (int) (Math.random() * 100) % 6;
        System.out.println(rand);


    }}
