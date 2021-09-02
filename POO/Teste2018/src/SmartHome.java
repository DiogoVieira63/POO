import java.util.HashMap;
import java.util.Map;

public class SmartHome {
    Map<String,Eletrodomestico> map;



    public SmartHome(Map<String,Eletrodomestico> novosEletrodomesticos){
        map = new HashMap<>();
        for (Map.Entry<String,Eletrodomestico> entry : novosEletrodomesticos.entrySet()){
            map.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public void addEletrodomestico(Eletrodomestico e){
        map.put(e.getIdent(),e);
    }


    public void desligaEletrodomestico(String id) throws EletrodomesticoNaoExiste{
        if (!map.containsKey(id)) throw new EletrodomesticoNaoExiste("Eletromestico não existe");
        Eletrodomestico eletrodomestico = map.get(id);
    }
}
