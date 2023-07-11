package Parque_Lugar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Parque {
    private Map <String, Lugar> parque;
    private String name;

    public Parque (){
        parque = new HashMap<String, Lugar>();
        name = "n/a";
    }

    public Parque(Map<String, Lugar> parque, String name) {
        this.parque = parque;
        this.name = name;
    }

    public Map<String, Lugar> getParque() {
        return parque;
    }

    public void setParque(Map<String, Lugar> parque) {
        this.parque = parque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String[] lugaresOcupados (){
        return (String[]) parque.keySet().toArray();
    }

    public void newLugar (Lugar info){
        parque.put(info.getMatricula(),info);
    }

    public void removeLugar (String matricula){
        parque.remove(matricula);
    }

    public void alteraTempo (String matricula, int time){
        Lugar lugar = parque.get(matricula);
        lugar.setMinutos(time);
    }

    public int totalMinutes (){
        return parque.values().stream().
                map(Lugar::getMinutos).
                reduce(0,Integer::sum);
    }

    public boolean existeLugar (String matricula){
        return parque.containsKey(matricula);
    }

    public String[] lugarTempoPermanente (int x){
        return (String[]) parque.values().stream().
                filter(Lugar::isPermanente).
                filter(lugar -> lugar.getMinutos() > x).
                map(Lugar::getMatricula).
                toArray();
    }

    public Lugar info (String matricula){
        return parque.get(matricula);
    }


    @Override
    public String toString() {
        return "Parque_Lugar.Parque{" +
                "parque=" + parque +
                ", name='" + name + '\'' +
                '}';
    }
}
