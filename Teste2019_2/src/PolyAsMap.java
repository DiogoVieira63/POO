import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PolyAsMap implements Poly{
    private Map<Integer,Double> map;

    public PolyAsMap (){
        map = new TreeMap<>();
    }

    public void addMonomio(int grau, double coeficiente) {
        map.put(grau,coeficiente);
    }

    public double calcula(double x) {
        double result = 0;
        for (Map.Entry<Integer,Double> entry : map.entrySet()){
            result += entry.getValue() * Math.pow(x, entry.getKey());
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer,Double> entry: map.entrySet()){
            String s = String.format("%+.1fx^%d" ,entry.getValue(),entry.getKey());
            stringBuilder.insert(0,s);
        }
        return stringBuilder.toString();
    }
}
