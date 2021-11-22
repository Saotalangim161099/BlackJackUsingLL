public class CardsDriver {
    public static void main(String args[]) {
        /*LLCards llC = new LLCards();
        Cardd c1 = new Cardd("5", "D");
        Cardd c2= new Cardd("1","D");
        Cardd c3= new Cardd("8","D");
        Cardd c4= new Cardd("9","D");

        llC.addCardNode(c1);
        llC.addCardNode(c2);
        llC.addCardNode(c3);
        llC.addCardNode(c4);
        llC.printCards();
        System.out.println("--------------");


        System.out.println("After shuffling: ");
        llC.shuffle();
        System.out.println("--------------");*/
        Deck newDeck=new Deck();
        newDeck.generateDeck();
        newDeck.shuffleDeck();
        newDeck.printDeck();




    }}
