import java.io.Serializable;
import java.util.List;

public class VeiculoPremium extends Veiculo implements Serializable {
    private double taxaLuxo;
    private int pontosKM;
    private int totalPontos;


    public VeiculoPremium (){
        super();
        this.taxaLuxo = 1;
    }

    public VeiculoPremium (VeiculoPremium veiculoPremium){
        super(veiculoPremium);
        this.taxaLuxo = veiculoPremium.taxaLuxo;
        this.totalPontos = veiculoPremium.totalPontos;
        this.pontosKM = veiculoPremium.pontosKM;
    }

    public VeiculoPremium(double taxaLuxo) {
        this.taxaLuxo = taxaLuxo;
    }

    public VeiculoPremium(String matricula, String marca, String modelo, int anoConstrucao, double velMediaPorKm, double precoMedioPorKm, List<Integer> clasisificacao, int numKms, double taxaLuxo) {
        super(matricula, marca, modelo, anoConstrucao, velMediaPorKm, precoMedioPorKm, clasisificacao, numKms);
        this.taxaLuxo = taxaLuxo;
    }

    public VeiculoPremium(Veiculo veiculo, double taxaLuxo) {
        super(veiculo);
        this.taxaLuxo = taxaLuxo;
    }

    public double getTaxaLuxo() {
        return taxaLuxo;
    }

    public void setTaxaLuxo(double taxaLuxo) {
        this.taxaLuxo = taxaLuxo;
    }

    public double custoRealKm (){
        return precoTotalPorKm() * taxaLuxo;
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
        return "VeiculoPremium{" +
                super.toString() +
                "taxaLuxo=" + taxaLuxo +
                '}';
    }

    public VeiculoPremium clone (){
        return new VeiculoPremium(this);
    }
}
