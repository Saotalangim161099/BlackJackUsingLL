public class Driver {
    public static void main(String args[]) {
        CardHand cardHand=new CardHand(true);

        cardHand.addLast(new LLCard("10","D",null));
        cardHand.addLast(new LLCard("1","D",null));
        cardHand.addLast(new LLCard("1","D",null));
        cardHand.addLast(new LLCard("1","D",null));

        //cardHand.printCards();
        //System.out.println("Total point is: "+cardHand.getPoint());
        System.out.println(cardHand.getTotalPoint());
        System.out.println("----------");
        //System.out.println(cardHand.size());
        //System.out.println("Is BlackJack?"+cardHand.isBlackJack());
        //LLCard card=new LLCard("12","H",null);
        //System.out.println(card.getCardValue());


    }
}
