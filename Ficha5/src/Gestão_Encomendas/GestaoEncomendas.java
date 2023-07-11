package Gestão_Encomendas;

import java.net.Inet4Address;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestaoEncomendas {
    Map<String, EncEficiente> encomendaMap;
    public GestaoEncomendas(){
        this.encomendaMap = new HashMap<>();
    }

    public GestaoEncomendas(Map<String, EncEficiente> encomendaMap) {
        setEncomendaMap(encomendaMap);
    }

    public GestaoEncomendas (GestaoEncomendas encomendas){
        setEncomendaMap(encomendas.getEncomendaMap());
    }


    public Map<String, EncEficiente> getEncomendaMap() {
        return encomendaMap;
    }


    public void setEncomendaMap (Map<String, EncEficiente> encomendaMap) {
        Map<String, EncEficiente> map = new HashMap<>();
        for (Map.Entry<String, EncEficiente> encEficienteEntry : encomendaMap.entrySet()) {
            if (map.put(encEficienteEntry.getKey(), encEficienteEntry.getValue().clone()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        this.encomendaMap = map;
    }

    public GestaoEncomendas clone (){
        return new GestaoEncomendas(this);
    }

    @Override
    public String toString() {
        return "GestaoEncomendas{" +
                "encomendaMap=" + encomendaMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestaoEncomendas that = (GestaoEncomendas) o;
        return Objects.equals(getEncomendaMap(), that.getEncomendaMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEncomendaMap());
    }

    public Set<String> todosCodigosEnc(){
        return (Set<String>) encomendaMap.keySet().stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    public void addEncomenda(EncEficiente enc){
        if (!encomendaMap.containsKey(enc))
            encomendaMap.put(enc.getEncomendaNumber(),enc);
    }

    public EncEficiente getEncomenda(String codEnc){
        EncEficiente result = null;
        if (encomendaMap.containsKey(codEnc))
            result = encomendaMap.get(codEnc);
        return result;
    }

    public void removeEncomenda(String codEnc){
        encomendaMap.remove(codEnc);
    }

    public Stream<Map.Entry<String, EncEficiente>> encomendaComMaisProdutos(){
        return encomendaMap.entrySet().stream().
                sorted(Comparator.comparingInt(enc -> enc.getValue().numeroTotalProdutos()));
    }

    public Set<String> encomendasComProduto(String codProd){
        return encomendaMap.entrySet().stream().
                filter(entry -> entry.getValue().existeProdutoEncomenda(codProd)).
                map(Map.Entry::getKey).
                collect(Collectors.toUnmodifiableSet());
    }

    public Set<String> encomendasAposData(LocalDate d){
        return encomendaMap.entrySet().stream().
                filter(entry -> entry.getValue().getDate().isAfter(d)).
                map(Map.Entry::getKey).
                collect(Collectors.toUnmodifiableSet());
    }

    public Set<EncEficiente> encomendasValorDecrescente(){
        return encomendaMap.entrySet().stream().
                sorted((entry, t1) -> (int) (t1.getValue().calculaValorTotal() - entry.getValue().calculaValorTotal())).
                map(Map.Entry::getValue).
                collect(Collectors.toUnmodifiableSet());
    }

    Map<String,List<String>> encomendasDeProduto(){
        Map <String,List<String>> result = new HashMap<>();
        for (Map.Entry<String,EncEficiente> entry: encomendaMap.entrySet()){
            for (LinhaEncomenda encomenda : entry.getValue().getArray()){
                if (!result.containsKey(encomenda.getReferencia())){
                    List <String> list = new ArrayList<>();
                    result.put(encomenda.getReferencia(),list);
                }
                result.get(encomenda.getReferencia()).add(entry.getValue().getEncomendaNumber());
            }
        }
        return result;
    }






}
