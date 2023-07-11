import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GinasioPOO implements Serializable {
    private Map< String,Cliente> clientes ;

    public double valorTotalCaloriasGastas(String codCliente) throws ClienteNaoExiste{
        if (!clientes.containsKey(codCliente)) throw new ClienteNaoExiste("Este cliente não existe: "+ codCliente);
        double total = 0;
        for (List<Exercicio> list: clientes.get(codCliente).getMeusExercicios().values()){
            for (Exercicio ex : list){
                total += ex.getActividade().caloriasGastas();
            }
        }
        return total;
    }

    public double totalKmsCliente ( String codCliente , LocalDate dataExercicio ) throws ClienteNaoExiste , ExercicioInexistente{
        if (!clientes.containsKey(codCliente)) throw  new ClienteNaoExiste("Este Cliente não exitse: "+ codCliente);
        if (!clientes.get(codCliente).getMeusExercicios().containsKey(dataExercicio)) throw new ExercicioInexistente("Exercicio inexistente no dia: "+ dataExercicio);
        double total = 0;
        for (Exercicio exercicio : clientes.get(codCliente).getMeusExercicios().get(dataExercicio)){
            Actividade actividade = exercicio.getActividade();
            if (actividade instanceof Corrida) total += ((Corrida) actividade).getKmsPercorridos();
            if (actividade instanceof Eliptica) total += ((Corrida) actividade).getKmsPercorridos();
        }
        return total;
    }

    public boolean existeProfessor(String prof){
        return clientes.values().stream().
                map(Cliente::getMeusExercicios).
                map(Map::values).
                anyMatch(lists -> lists.stream().anyMatch(exercicios -> exercicios.stream().anyMatch(exercicio -> exercicio.getProfessor().equals(prof))));
    }

    private double caloriasProf (List<Exercicio> list){
        int result = 0;
        for (Exercicio ex : list){
            result += ex.getActividade().caloriasGastas();
        }
        return  result;
    }

    public String professorMaisExigente(){
        double maior = 0;
        String maisExigente = null;
        for (Cliente cliente : clientes.values()){
            Map<String, List<Exercicio>> meusExercicios = cliente.exerciciosPorProf();
            double total = 0;
            for (Map.Entry<String, List<Exercicio>> entry: meusExercicios.entrySet()) {
                total = caloriasProf(entry.getValue());
                if (total > maior) {
                    maior = total;
                    maisExigente = entry.getKey();
                }
            }
        }
        return maisExigente;
    }
}