import java.io.Serializable;
import java.util.List;

public class VeiculoOcasiao extends Veiculo implements Serializable {
    private boolean desconto;

    public VeiculoOcasiao (){
        super();
        this.desconto = false;
    }
    public VeiculoOcasiao(VeiculoOcasiao v){
        super(v);
        this.desconto = v.desconto;
    }

    public VeiculoOcasiao(String matricula, String marca, String modelo, int anoConstrucao, double velMediaPorKm, double precoMedioPorKm, List<Integer> clasisificacao, int numKms, boolean desconto) {
        super(matricula, marca, modelo, anoConstrucao, velMediaPorKm, precoMedioPorKm, clasisificacao, numKms);
        this.desconto = desconto;
    }

    public boolean isDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public double custoRealKm (){
        return isDesconto() ? precoTotalPorKm() * 0.75 : precoTotalPorKm();
    }

    @Override
    public String toString() {
        return "VeiculoOcasiao{" +
                super.toString() +
                "desconto=" + desconto +
                '}';
    }

    public VeiculoOcasiao clone (){
        return new VeiculoOcasiao(this);
    }
}
