import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class POOAirBnB implements Serializable {
    private Map< String , Imovel > imoveis ;
    private Map < String , Cliente > clientes ;


    public void insereImovel(Imovel i) throws ImovelJaExistente{
        if (imoveis.containsValue(i)) throw new ImovelJaExistente("Este imovél já existe");
        imoveis.put(i.getCodImovel(),i);
    }

    public double valorTotalAluguerCliente(String codCliente) throws ClienteNaoExiste{
        if (!clientes.containsKey(codCliente)) throw new ClienteNaoExiste("O Cliente com ID "+ codCliente+" não existe");
        Cliente cliente = clientes.get(codCliente);
        int result = 0;
        for (Aluger aluger : cliente.getMeusAlugueres()){
            Imovel imovel = imoveis.get(aluger.getCodImovel());
            result += imovel.precoDia();
        }
        return result;
    }

    public String clienteMaisGastador(){
        return clientes.entrySet().stream().
                sorted((stringClienteEntry, t1) -> {
                    double var = 0;
                    try {
                        var = valorTotalAluguerCliente(stringClienteEntry.getKey()) - valorTotalAluguerCliente(t1.getKey());
                    } catch (ClienteNaoExiste clienteNaoExiste) {
                        clienteNaoExiste.printStackTrace();
                    }
                    return (int) var;
                }).
                map(Map.Entry::getKey).
                collect(Collectors.toList()).
                get(clientes.size() -1);
    }


    public void clientesImovel (Set<String> set, String imovelCod){
        for ( Cliente cliente : clientes.values()){
            if (cliente.getMeusAlugueres().stream().anyMatch(aluger -> aluger.getCodImovel().equals(imovelCod))) set.add(cliente.getCodCliente());
        }
    }

    public Map<String, Set<String>> clientesPorImovel(){
        Map <String,Set<String>> map = new HashMap<>();
        for (Map.Entry<String,Imovel> entry: imoveis.entrySet()){
            Set <String> set = new HashSet<>();
            map.putIfAbsent(entry.getKey(), set);
            clientesImovel(set, entry.getKey());
        }
        return map;
    }
}

