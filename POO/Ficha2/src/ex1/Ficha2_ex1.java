public class Ficha2_ex1 {
    public int valorMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) min = value;
        }
        return min;
    }

    public int[] inBetween(int[] array, int a, int b) {
        int[] new_array = new int[b - a - 1];
        for (int i = a + 1, u = 0; i < b; i++, u++) new_array[u] = array[i];
        return new_array;
    }

    public int[] equalArray(int[] a, int[] b) {
        int[] temp_array = new int[Math.min(a.length, b.length)];
        int i = 0;
        for (int value_a : a) {
            for (int value_b : b) {
                if (value_a == value_b) {
                    temp_array[i++] = value_a;
                    break;
                }
            }
        }
        int[] new_array = new int[i];
        System.arraycopy(temp_array, 0, new_array, 0, new_array.length);
        return new_array;
    }
}
