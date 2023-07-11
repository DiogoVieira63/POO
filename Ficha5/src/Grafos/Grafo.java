package Grafos;

import java.net.Inet4Address;
import java.util.*;

public class Grafo {
    private Map<Integer,Set<Integer>> adj ;

    public Grafo (){
        this.adj = new HashMap<>();
    }

    public Grafo(Map<Integer, Set<Integer>> adj) {
        this.adj = new HashMap<>();
        for (Map.Entry <Integer,Set<Integer>> entry : adj.entrySet()){
            this.adj.put(entry.getKey(),entry.getValue());
        }
    }

    public void addArco(Integer vOrig, Integer vDest){
        adj.putIfAbsent(vOrig,new HashSet<>());
        adj.putIfAbsent(vDest,new HashSet<>());
        adj.get(vOrig).add(vDest);
    }

    public boolean isSink(Integer v){
        return adj.containsKey(v) && adj.get(v).isEmpty();
    }

    public boolean isSource(Integer v){
        return adj.containsKey(v) && adj.entrySet().stream().noneMatch(entry -> entry.getValue().contains(v));
    }

    public int size(){
        return this.adj.size() + this.adj.values().stream().mapToInt(Set::size).sum();
    }

    public boolean haCaminho(Integer orig, Integer dest) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visitados = new ArrayList<>();
        visitados.add(orig);
        queue.add(orig);
        while (queue.size() != 0){
            orig = queue.poll();
            for (Integer n : adj.get(orig)){
                if (n.equals(dest)) return true;
                if (!visitados.contains(n)){
                    visitados.add(n);
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public List<Integer> getCaminho(Integer orig, Integer dest) {
        if (!haCaminho(orig,dest))return null;
        List<Integer> visitados = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(orig);
        visitados.add(orig);
        Integer ant = orig;
        while (!ant.equals(dest)){
            for (Integer n : adj.get(ant)){
                if (n.equals(dest)) {
                    result.add(dest);
                    return result;
                }
                if (!visitados.contains(n) && haCaminho(n,dest)){
                    visitados.add(n);
                    result.add(n);
                    ant = n;
                    break;
                }
            }
        }
        return result;

    }

    public Set<Map.Entry<Integer, Integer>> fanOut (Integer v){
        Set<Map.Entry<Integer,Integer>> result = new HashSet<>();
        for (Integer o: adj.get(v)){
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(v, o);
            result.add(entry);
        }
        return result;
    }

    public Set<Map.Entry<Integer, Integer>> fanIn(Integer v){
        Set<Map.Entry<Integer,Integer>> result = new HashSet<>();
        adj.forEach((key, value) -> {
            if (value.contains(v)) {
                Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(key, v);
                result.add(entry);
            }
        });
        return result;
    }

    public boolean subGrafo(Grafo g) {
        return g.adj.keySet().containsAll(this.adj.keySet()) && g.adj.entrySet().stream()
                .allMatch(e -> !this.adj.containsKey(e.getKey()) || e.getValue().containsAll(this.adj.get(e.getKey())));
    }

}
