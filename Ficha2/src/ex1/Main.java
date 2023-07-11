import java.util.Scanner;

public class Main {

    public static int[] lerInput2Array() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers to read?");
        int n = input.nextInt();
        int []array = new int[n];
        for (int i = 0; i < array.length;i++) {
            System.out.println(i + "/"  + array.length + " - Write a number:");
            array[i] = input.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        Ficha2_ex1 f = new Ficha2_ex1();
        //EXERCISE 1 a)

        int[]array_1a = lerInput2Array();
        System.out.println("The minimum value of the array is " + f.valorMin(array_1a));

        //EXERCISE 1 b)

         int[] array_1b1 = lerInput2Array();
         int[] array_1b2 = f.inBetween(array_1b1,2,4);
         for (int value : array_1b2) System.out.println(value);

        //EXERCISE 1 c)

        int[] a = lerInput2Array();
        int[] b = lerInput2Array();
        int[] array_1c = f.equalArray(a,b);
        for (int value : array_1c) System.out.println(value);

    }
}
