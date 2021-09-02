
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class LocalData {
    private LocalDate items[];
    private int num_elems;

    public LocalData(int size) {
        this.items = new LocalDate[size];
        this.num_elems = 0;
    }

    public void insereData(LocalDate data) {
        if (this.num_elems < this.items.length) this.items[this.num_elems++] = data;
    }

    public void printData() {
        for (LocalDate date : this.items) System.out.println(date);
    }

    public String to_String() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.num_elems;i++) {
            str.append(this.items[i]);
            str.append('\n');
        }
        return str.toString();
    }

    public LocalDate dataMaisProxima(LocalDate data) {
        LocalDate date_result = LocalDate.MAX;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < this.num_elems;i++){
            int comparison = data.compareTo(this.items[i]);
            if (comparison < result){
                result = comparison;
                date_result = this.items[i];
            }
        }
        return date_result;
    }

}


