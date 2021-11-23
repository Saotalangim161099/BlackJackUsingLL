public class Driver {
    public static void main(String args[]) {
        Deck deck = new Deck();
        deck.printCards();
        System.out.println("Shuffling 1");
        deck.shuffle();
        deck.printCards();
        System.out.println("Shuffling 2");
        deck.shuffle();
        deck.printCards();
        System.out.println("Shuffling 3");
        deck.shuffle();
        deck.printCards();
        System.out.println("Shuffling 4");
        deck.shuffle();
        deck.printCards();
        System.out.println("Shuffling 5");
        deck.shuffle();
        deck.printCards();
    }
}
