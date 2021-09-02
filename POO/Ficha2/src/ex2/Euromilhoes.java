import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Euromilhoes {
    private int[]numeros;
    private int[]estrelas;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int[] random (int size, int max){
        int array[] = new int[size];
        for (int i = 0; i < size;i++){
            array[i] = getRandomNumber(1,max);
        }
        return  array;
    }

    public Euromilhoes(){
        this.numeros = random(5,50);
        this.estrelas = random(2,12);
    }

    private void print_chave (int count){
        char spaces[] = new char[count];
        for (int i = 0; i < count;i++) spaces[i] = ' ';
        System.out.println(new String(spaces) + toString());
    }

    public void your_bet (){
        System.out.println(toString());
        boolean win = true;
        Scanner scan = new Scanner(System.in);
        int numeros[] = new int[5];
        int estrelas[] = new int[2];
        System.out.println("Escreva os 5 númeors:");
        for (int i = 0; i < 5; i++)
            numeros[i] = scan.nextInt();
        System.out.println("Escreva as 2 estrelas:");
        for (int i = 0; i < 2;i++)
            estrelas[i] = scan.nextInt();
        for (int i = 0; i < 5;i++)
            if (!exist(numeros[i],true)) win = false;
        for (int i = 0; i < 2;i++)
            if (!exist(estrelas[i],false))win = false;
        if (win) {
            for (int i = 0; i < 50; i++)
                print_chave(2 * i);
        }
        else System.out.println(toString());
    }

    public boolean exist (int number, boolean numero){
        if (numero){
            for (int i = 0; i < 5;i++)
                if (getNumerosIndex(i) == number) return true;
        }
        else {
            for (int i = 0; i < 2;i++)
                if(getEstrelasIndex(i) == number)return true;
        }
        return false;

    }
    @Override
    public String toString() {
        return "numeros=" + Arrays.toString(numeros) +
                ", estrelas=" + Arrays.toString(estrelas) +
                '}';
    }

    public int getNumerosIndex (int index){
        return this.numeros[index];
    }
    public int getEstrelasIndex (int index){
        return this.estrelas[index];
    }
}
