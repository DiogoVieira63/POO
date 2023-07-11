

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static int what_day (int dia, int mês, int ano){
        int result = (ano -1900) *365;
        result+= (ano-1900)/4;
        if (ano%4 == 0 && mês <= 2) result++;
        int ano_dias = 0;
        for (int i = 1; i < mês;i++){
            switch (i%2){
                case 0:
                    if (i ==2) {
                        if (ano % 4 == 0) result += 29;
                        else ano_dias += 28;
                    }
                    else if (i < 7)ano_dias+=30;
                        else ano_dias+=31;
                    break;
                case 1:
                    if (i<= 7)ano_dias+=31;
                    else ano_dias+=30;
                    break;
            }
        }
        return (result + ano_dias + dia)%7;
    }
    public static void classificacoes (int n) {
        int []classf ={0,0,0,0};
        Scanner input =  new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println(i +"/"+n +" - Introduza a nota:");
            float nota = input.nextFloat();
            if (nota ==20)nota--;
            classf[(int)nota/5]++;
        }
        for (int i = 0; i < 4;i++){
            System.out.println("Notas entre " + (i*5) + " e " + ((i+1)*5) +":" +  classf[i]);
        }
    }

    public  static  void temperatura (int n){
        if (n < 2) return;
        Scanner input = new Scanner(System.in);
        float lastTemp = input.nextFloat(), total = lastTemp, variacao = 0;
        int index = 0;
        for (int i = 1; i < n;i++){
            float temp = input.nextFloat();
            total += temp;
            if (Math.abs(temp - lastTemp) > Math.abs(variacao)){
                index = i;
                variacao = temp -lastTemp;
            }
            lastTemp = temp;
        }
        float media = total/n;
        String str = (variacao > 0 ? "subido " : "descido ");
        System.out.println("A média das " + n + " temperaturas foi de " + media + " graus.");
        System.out.println("A maior variação registou-se entre os dias "+ index +  " e " + (index+1) + " tendo a temperatura " + str + Math.abs(variacao) +" graus.");
    }

    public static void triangulo() {
        Scanner input = new Scanner(System.in);
        while (true){
            double altura, base, hipotenusa, area, perimetro = 0;
            System.out.print("Escolha a base:");
            base = input.nextDouble();
            if (base == 0)break;
            System.out.print("Escolha a altura:");
            altura = input.nextDouble();
            hipotenusa = Math.sqrt(Math.pow(base,2) + Math.pow(altura,2));
            System.out.println(hipotenusa);
            perimetro += base + altura + hipotenusa;
            area = base * altura /2;
            System.out.printf("A área é %.5f e o perímetro é %.5f.\n",area,perimetro);
        }
    }

    public static boolean isItPrimo(int n) {
        for (int i = 2; i <= n/2; i++ ){
            if (n%i == 0) return false;
        }
        return true;
    }

    public static void primeNumber() {
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while (flag){
            System.out.println("Choose a number:");
            int number = input.nextInt();
            System.out.print("Prime numbers under " + number +":\n{");
            for (int i = number-1; i > 1; i--){
                if (isItPrimo(i)) System.out.print( i + ",");
            }
            System.out.println("\b}\nDo you want to play again? true or false");
            flag = input.nextBoolean();
        }
    }

    public static void idade() {
        Scanner input = new Scanner(System.in);
        int ano, mes, dia;
        System.out.println("Escreva o ano:");
        ano = input.nextInt();
        System.out.println("Escreva o mes:");
        mes = input.nextInt();
        System.out.println("Escreva o dia:");
        dia = input.nextInt();
    }

    public static void main(String[] args) {
        int day = what_day(25,2,2021);
        //Month february = date.getMonth();
        //LocalDate date = LocalDate.of(2021,2,25);
        //Month month = date.getMonth();
        //classificacoes(10);
        //temperatura(4);
        //triangulo();
        primeNumber();
    }
}
