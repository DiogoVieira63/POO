public class Main {
    public static void main(String[] args) {
        PolyAsList list = new PolyAsList();
        list.addMonomio(0,3);
        list.addMonomio(1,1);
        list.addMonomio(2,2);
        list.addMonomio(3,5);
        list.addMonomio(3,1);
        list.addMonomio(1,2);
        System.out.println(list.toString());
        System.out.println(list.derivada());
    }

}
