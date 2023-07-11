import java.util.Arrays;

public class array_sort {
    public void sort_array (int[]array){
        Arrays.sort(array);
    }
    public int bin_search (int[] array, int element){
        int result = Arrays.binarySearch(array,element);
        return result;
    }
}
