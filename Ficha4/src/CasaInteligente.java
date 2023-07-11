import java.util.ArrayList;
import java.util.stream.Collectors;

public class CasaInteligente {
    private ArrayList<Lampada> array;


    public void addLampada(Lampada l){
        this.array.add(l);
    }

    public void ligaLampadaNormal(int index){
        if (index < this.array.size()) {
            Lampada l = this.array.get(index);
            l.lampON();
            this.array.set(index, l);
        }
    }
    public void ligaLampadaEco(int index){
        if (index < this.array.size()) {
            Lampada l = this.array.get(index);
            l.lampECO();
            this.array.set(index, l);
        }
    }
    public int qtEmEco(){
        return (int) this.array.stream().filter(Lampada::isEco).count();
    }

    public void removeLampada(int index){
        if (index < this.array.size())
            this.array.remove(index);
    }
    public void ligaTodasEco(){
        this.array.forEach(Lampada::lampECO);
    }
    public void ligaTodasMax(){
        this.array.forEach(Lampada::lampON);
    }

    public double consumoTotal(){
        double total = 0;
        for (Lampada l : this.array){
            total += l.totalConsumo();
        }
        return total;
    }

    //TODO reset
    public void reset(){

    }

}
