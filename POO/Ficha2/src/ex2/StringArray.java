import java.util.Scanner;

public class StringArray {
    private final String[] array;
    private final int size;
    private int occupation;

    public StringArray(int size){
        Scanner input = new Scanner(System.in);
        this.array = new String[size];
        this.size = size;
        this.occupation = 0;
    }

    public String to_String (){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < getOccupation();i++){
            str.append(this.array[i]);
            str.append(" | ");
        }
        return str.toString();
    }
    public String maiorString (){
        String longest_string = "";
        for (int i = 0; i < getOccupation();i++){
            String string = this.array[i];
            if (string.length() > longest_string.length())longest_string= string;
        }
        return longest_string;
    }

    public void insereString (String str){
        if (getOccupation() == getSize()) return;
        this.array[getOccupation()] = str;
        this.occupation++;
    }

    public int count (String str){
        int result = 0;
        for (int i = 0; i < getOccupation();i++){
            if (this.array[i].equals(str)) result++;
        }
        return result;
    }

    public StringArray different(){
        StringArray result;
        result = new StringArray(this.getOccupation());
        for (int i = 0; i < getOccupation();i++){
            if (count (this.array[i]) == 1) result.insereString(this.array[i]);
        }
        return result;
    }

    public StringArray repetidos (){
        StringArray result;
        result = new StringArray(this.getOccupation());
        for (int i = 0; i < getOccupation();i++){
            if (count(this.array[i]) > 1) {
                if (result.count(this.array[i]) != 1) result.insereString(this.array[i]);
            }
            }
        return result;
    }

    public int getOccupation() {
        return occupation;
    }

    public int getSize() {
        return size;
    }

    public String[] getArray() {
        return array;
    }
}
