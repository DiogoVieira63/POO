import java.util.ArrayList;
import java.util.List;

import javax.swing.text.GapContent;

public class PolyAsList implements Poly{
    private List<Double> list;


    public PolyAsList (){
        this.list = new ArrayList<>();
    }

    public void addMonomio(int grau, double coeficiente) {
        if (grau >= list.size()) {
            for (int i = 0; list.size() <= grau ;i++)list.add((double) 0);
        }
        double valor = list.get(grau);
        list.set(grau, coeficiente + valor);
    }

    
    public double calcula(double x) {
        double result = 0;
        for (int i = 0; i < list.size();i++) {
            result += list.get(i) * i;
        }
        return result;
    }

    public int grau() {
        return list.size() -1;
    }

    public Poly derivada() {
        Poly result = new PolyAsList();
        for (int i = 1; i < list.size();i++){
            result.addMonomio(i -1,list.get(i) * i);
        }
        return result;
    }

    @Override
    public String toString() {
        return "PolyAsList{" +
                "list=" + list +
                '}';
    }
}
