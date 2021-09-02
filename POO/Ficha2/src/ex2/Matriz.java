public class Matriz {
    private int size;
    private int [][]array;

    public Matriz(int size, int[][] array) {
        this.size = size;
        this.array = array;
    }

    public Matriz(int size) {
        this.size = size;
        this.array = new int [size][size];
    }
    //TBD
}
