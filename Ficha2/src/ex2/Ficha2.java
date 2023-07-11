public class Ficha2 {
    public int sum_uc(int[][] array, int uc) {
        int result = 0;
        for (int[] alunos : array) {
            result += alunos[uc];
        }
        return result;
    }

    public double mediaAluno(int[][] array, int aluno) {
        double total = 0;
        for (int i = 0; i < array[aluno].length; i++) {
            total += (double) array[aluno][i];
        }
        return total / array[aluno].length;
    }

    public double mediaUC(int[][] array, int uc) {
        double total = 0;
        for (int[] aluno : array) {
            total += (double) aluno[uc];
        }
        return total / array.length;
    }

    public int notaMaisAlta(int[][] array) {
        int maisAlta = -1;
        for (int[] aluno : array)
            for (int nota : aluno) if (nota > maisAlta) maisAlta = nota;
        return maisAlta;
    }

    public int notaMaisBaixa(int[][] array) {
        int maisBaixa = 21;
        for (int[] aluno : array)
            for (int nota : aluno) if (nota < maisBaixa) maisBaixa = nota;
        return maisBaixa;
    }

    public int[] higherThan(int[][] array, int value) {
        int[] temp_array = new int[array.length * array[0].length];
        int i = 0;
        for (int[] alunos : array)
            for (int nota : alunos) if (nota > value) temp_array[i++] = nota;
        int[] new_array = new int[i];
        System.arraycopy(temp_array, 0, new_array, 0, i);
        return new_array;
    }
    public String toString (int [][]array){
        String str = "";
        for (int [] alunos : array) {
            for (int nota : alunos) {
                str += String.valueOf(nota);
                str += " ";
            }
        }
        return str;
    }
    public int mediaMaisAlta (int [][]array){
        double mediaAlta = -1;
        int index = -1;
        for (int i = 0; i < array.length;i++){
            double media = mediaUC(array,i);
            if (media > mediaAlta) {
                mediaAlta = media;
                index = i;
            }
        }
        return index;
    }
}
