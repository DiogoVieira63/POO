import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {
    private String nome ;
    private String codCliente ;
    private List<Aluger> meusAlugueres ;

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

    public List<Aluger> getMeusAlugueres() {
        return meusAlugueres;
    }

    public void setMeusAlugueres(List<Aluger> meusAlugueres) {
        this.meusAlugueres = meusAlugueres;
    }
}