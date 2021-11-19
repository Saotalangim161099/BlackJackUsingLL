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
        Cardd c6=new Cardd("9","D");
        llC.addCardNode(c6);


        //Cardd c5=new Cardd("","D");
        //llC.addCardNode(c2);
        //Cardd c6=new Cardd("7","D");
        //llC.addCardNode(c2);



        llC.printCards();



    }}
