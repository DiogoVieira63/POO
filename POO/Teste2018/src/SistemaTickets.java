import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaTickets {
    private Map< String, Tecnico > funcionarios ; // funcionarios da empresa
    private List<Ticket> ticketsPorResolver ; // tickets ainda n~a o tratados
    private List<Ticket> ticketsResolvidos ; // tickets já satisfeitos

    public SistemaTickets (){
        funcionarios = new HashMap<>();
        ticketsPorResolver = new ArrayList<>();
        ticketsResolvidos = new ArrayList<>();
    }

    public void adicionaTicket(Ticket t){
        ticketsPorResolver.add(t);
    }
    public void resolveTicket(String ident) throws TecnicoNaoExisteException{
        if (!funcionarios.containsKey(ident)) throw new TecnicoNaoExisteException("Tecnico não existe");
        Ticket unsolved = ticketsPorResolver.get(0);
        unsolved.executaTarefa();
        ticketsResolvidos.add(unsolved);
        ticketsPorResolver.remove(0);
    }

    public Map<String,List<Ticket>> ticketsPorTecnico(){
        Map<String,List<Ticket>> map = new HashMap<>();
        for (Ticket ticket : ticketsResolvidos){
            map.putIfAbsent(ticket.getIdentTecnico(),new ArrayList<>());
            map.get(ticket.getIdentTecnico()).add(ticket);
        }
        return map;
    }

    public String supervisorTop(){
        Map<String,List<Ticket>> map = ticketsPorTecnico();
        int maior = 0;
        String result = null;
        for (Map.Entry<String,List<Ticket>> entry : map.entrySet()){
            if (entry.getValue().size() > maior){
                maior = entry.getValue().size();
                result = entry.getKey();
            }
        }
        return result;
    }
}

