import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void randomNotas (int [][] array){
        Random rand = new Random();
        for (int i = 0; i < array.length;i++){
            for (int u = 0; u < array[i].length;u++) array[i][u] = rand.nextInt(20);
        }
    }
    public static void lerNotas (int [][] array){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Qual o aluno?");
            int aluno = input.nextInt();
            System.out.println("Qual a disciplina?");
            int uc = input.nextInt();
            System.out.println("Qual a nota");
            int nota = input.nextInt();
            if (aluno == -1 || uc == -1 || nota == -1)break;
            array[aluno][uc] = nota;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Ficha2 f = new Ficha2();
        /*
        //EXERCICIO 2 a)

         int [][]notasTurma = new int[5][5];
         //lerNotas(notasTurma);
        randomNotas(notasTurma);

        //EXERCICIO 2 b

        int soma = f.sum_uc(notasTurma,0);
        System.out.println("A soma das notas da uc 0 foi " + soma);

        //EXERCICIO 2 c)

        double media_aluno = f.mediaAluno(notasTurma,0);
        System.out.println("A média do aluno foi: " + media_aluno);

        //EXERCICIO 2 d)

        double media_uc = f.mediaUC(notasTurma,0);
        System.out.println("A média da Uc foi: " + media_uc);

        //EXERCICIO 2 e)

        int maisAlta = f.notaMaisAlta(notasTurma);
        System.out.println("A nota mais alta foi "+ maisAlta);

        // EXERCICIO 2 f)

        int maisBaixa = f.notaMaisBaixa(notasTurma);
        System.out.println("A nota mais baixa foi "+ maisBaixa);

        //EXERCICIO 2 g)

        int []new_array = f.higherThan(notasTurma,10);
        System.out.println("As notas mais altas do que 10 são:");
        for (int notas : new_array) System.out.println(notas);

         //EXERCICIO 2 h)

        String str = f.toString(notasTurma);
        System.out.println(str);

        //EXERCICIO 2 i)

        int maisElevada = f.mediaMaisAlta(notasTurma);
        System.out.println("A média mais alta foi da uc nº" + maisElevada);
        for (int []aluno: notasTurma)
            for (int nota: aluno) System.out.println(nota);


        LocalData localData = new LocalData(10);
        LocalDate date = LocalDate.now();
        localData.insereData(LocalDate.of(2020,3,25));
        localData.insereData(LocalDate.of(2019,4,1));
        localData.insereData(LocalDate.of(2021,3,25));
        localData.insereData(LocalDate.of(2018,5,24));
        localData.insereData(LocalDate.of(2017,6,17));
        String str = localData.to_String();
        //LocalDate result = localData.dataMaisProxima(date);
        System.out.println(str);

        array_sort arr = new array_sort();
        int []array ={4,5,1,2,3};
        arr.sort_array(array);
        for (int item : array) System.out.println(item);
        int res = arr.bin_search(array,3);
        System.out.println(res);


        StringArray array = new StringArray(5);
        array.insereString("Diogo");
        array.insereString("Diogo");
        array.insereString("Andrea");
        StringArray other = array.different();
        //int times = array.count("Diogo");
        //System.out.println(times);
        String s = other.to_String();
        System.out.println(s);
         */
        Euromilhoes euro = new Euromilhoes();
        euro.your_bet();

    }

}