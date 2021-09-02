import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente implements Serializable {
    private String nome ;
    private String codCliente ;
    private Map<LocalDate, List< Exercicio >> meusExercicios ;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Map<LocalDate, List<Exercicio>> getMeusExercicios() {
        return meusExercicios;
    }

    public void setMeusExercicios(Map<LocalDate, List<Exercicio>> meusExercicios) {
        this.meusExercicios = meusExercicios;
    }

    public Map<String, List<Exercicio>> exerciciosPorProf(){
        Map <String,List<Exercicio>> map = new HashMap<>();
        for (List<Exercicio> list : meusExercicios.values()){
            for (Exercicio ex : list){
                map.putIfAbsent(ex.getProfessor(), new ArrayList<>());
                map.get(ex.getProfessor()).add(ex);
            }
        }
        return map;
    }

}