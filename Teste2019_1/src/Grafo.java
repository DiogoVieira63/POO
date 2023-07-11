import java.util.HashSet;
import java . util . Set ;
import java . util . Map ;
import java . util . HashMap ;
public class Grafo {
    private Map <String,Set <String>> adj;


    public Grafo (){
        this.adj = new HashMap<>();
    }

    public Grafo (Map<String,Set<String>> map){
        this.adj = new HashMap<>();
        for (Map.Entry<String,Set<String>> entry : map.entrySet()){
            adj.putIfAbsent(entry.getKey(),new HashSet<>());
            for (String s : entry.getValue())
                adj.get(entry.getKey()).add(s);
        }
    }

    public void addArco(String vOrig, String vDest){
        adj.putIfAbsent(vOrig,new HashSet<>());
        adj.putIfAbsent(vDest,new HashSet<>());
        adj.get(vOrig).add(vDest);
    }

    public boolean isSink(String v){
        return adj.get(v).size() == 0;
    }

    public int size(){
        int result = adj.size();
        for (Set<String> set : adj.values()){
            result += set.size();
        }
        return result;
    }

    public Set<Map.Entry<String, String>> fanOut (String v){
        Set <Map.Entry<String,String>> newSet = new HashSet<>();
        for (String s : adj.get(v)){
            newSet.add(Map.entry(v,s));
        }
        return newSet;
    }
}