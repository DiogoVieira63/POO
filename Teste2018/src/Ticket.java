import java.time.LocalDateTime;

public class Ticket {
    private String nomeO ; // quem originou o pedido
    private LocalDateTime horaOcorrencia ; // instante do report do ticket
    private String assunto ;
    private String descricao ;
    private String identTecnico ; // técnico que resolveu o ticket
    private LocalDateTime horaFecho ; // instante do fecho do ticket


    public String getNomeO() {
        return nomeO;
    }

    public void setNomeO(String nomeO) {
        this.nomeO = nomeO;
    }

    public LocalDateTime getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(LocalDateTime horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentTecnico() {
        return identTecnico;
    }

    public void setIdentTecnico(String identTecnico) {
        this.identTecnico = identTecnico;
    }

    public LocalDateTime getHoraFecho() {
        return horaFecho;
    }

    public void setHoraFecho(LocalDateTime horaFecho) {
        this.horaFecho = horaFecho;
    }

    public void executaTarefa (){
    }
}