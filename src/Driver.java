public class Driver {
    public static void main(String args[]) {
        Deck deck = new Deck(false);
        deck.shuffle();
        deck.printCards();
        System.out.println("There are " + deck.size() + " cards");


    }
}
