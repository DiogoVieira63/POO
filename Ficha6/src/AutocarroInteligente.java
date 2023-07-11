import java.io.Serializable;
import java.util.List;

public class AutocarroInteligente extends Veiculo implements BonificaKms, Serializable {
    private double ocupacao;
    private int pontosKM;
    private int totalPontos;


    public AutocarroInteligente (){
        super();
        this.ocupacao = 0;
    }

    public AutocarroInteligente(String matricula, String marca, String modelo, int anoConstrucao, double velMediaPorKm, double precoMedioPorKm, List<Integer> clasisificacao, int numKms, double ocupacao) {
        super(matricula, marca, modelo, anoConstrucao, velMediaPorKm, precoMedioPorKm, clasisificacao, numKms);
        this.ocupacao = ocupacao;
    }

    public AutocarroInteligente(AutocarroInteligente autocarroInteligente) {
        super(autocarroInteligente);
        this.ocupacao = autocarroInteligente.ocupacao;
    }

    public double getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(double ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double custoRealKm() {
        return (ocupacao <= 0.6) ?  precoTotalPorKm() * 0.5 : precoTotalPorKm() * 0.75;
    }

    public int getPontosPorKM(){
        return this.pontosKM;
    }
    public void setPontosPorKm (int pontos){
        this.pontosKM =pontos;
    }

    public int getTotalPontos(){
        return totalPontos;
    }

    public void addPontos (int numKms){
        this.totalPontos += numKms *pontosKM;
    }

    @Override
    public String toString() {
        return "AutocarroInteligente{" +
                super.toString() +
                "ocupacao=" + ocupacao +
                '}';
    }

    public AutocarroInteligente clone (){
        return new AutocarroInteligente(this);
    }
}
