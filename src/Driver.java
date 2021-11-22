public class Driver {
    public static void main(String args[]) {
        ArrayClass names = new ArrayClass(5);
        names.add("Anna");
        names.add("Bob");
        names.add("Ceci");
        names.add("Dave");
        names.displayArray();
        System.out.println(names.size());
    }
}
