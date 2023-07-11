import java.io.Serializable;
import java.time.LocalDate;

public class Aluger implements Serializable {
    private String codCliente ;
    private String codImovel ;
    private LocalDate dataInicio ;
    private LocalDate dataFim ;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(String codImovel) {
        this.codImovel = codImovel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}