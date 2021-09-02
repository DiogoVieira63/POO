import java.io.Serializable;
import java.util.List;

abstract class Veiculo implements Comparable <Veiculo>, Serializable {
    private String matricula;
    private String marca;
    private String modelo;
    private int anoConstrucao;
    private double velMediaPorKm;
    private double precoMedioPorKm;
    private List<Integer> clasisificacao;
    private int numKms;

    public Veiculo (){
        this.matricula = "n/a";
        this.marca = "n/a";
        this.modelo = "n/a";
        this.anoConstrucao = 0;
        this.velMediaPorKm = 0;
        this.precoMedioPorKm = 0;
        this.clasisificacao = null;
        this.numKms = 0;
    }

    public Veiculo(String matricula, String marca, String modelo, int anoConstrucao, double velMediaPorKm, double precoMedioPorKm, List<Integer> clasisificacao, int numKms) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoConstrucao = anoConstrucao;
        this.velMediaPorKm = velMediaPorKm;
        this.precoMedioPorKm = precoMedioPorKm;
        this.clasisificacao = clasisificacao;
        this.numKms = numKms;
    }

    public Veiculo (Veiculo veiculo){
        this.matricula = veiculo.matricula;
        this.marca = veiculo.marca;
        this.modelo = veiculo.modelo;
        this.anoConstrucao = veiculo.anoConstrucao;
        this.velMediaPorKm =veiculo.velMediaPorKm;
        this.precoMedioPorKm = veiculo.precoMedioPorKm;
        this.clasisificacao = veiculo.clasisificacao;
        this.numKms = veiculo.numKms;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getVelMediaPorKm() {
        return velMediaPorKm;
    }

    public void setVelMediaPorKm(double velMediaPorKm) {
        this.velMediaPorKm = velMediaPorKm;
    }

    public double getPrecoMedioPorKm() {
        return precoMedioPorKm;
    }

    public void setPrecoMedioPorKm(double precoMedioPorKm) {
        this.precoMedioPorKm = precoMedioPorKm;
    }

    public List<Integer> getClasisificacao() {
        return clasisificacao;
    }

    public void setClasisificacao(List<Integer> clasisificacao) {
        this.clasisificacao = clasisificacao;
    }

    public int getNumKms() {
        return numKms;
    }

    public void setNumKms(int numKms) {
        this.numKms = numKms;
    }

    public void addNumKs (int numKms){
        this.numKms += numKms;
    }

    public void addClassificacao (int classificacao){
        this.clasisificacao.add(classificacao);
    }


    public double precoTotalPorKm (){
        return precoMedioPorKm * numKms * 1.10;
    }

    public abstract double custoRealKm();

    public abstract Veiculo clone();

    public int compareTo (Veiculo veiculo){
        int compare;
        if ((compare = this.marca.compareTo(veiculo.marca)) != 0)
            return compare;
        return this.modelo.compareTo(veiculo.modelo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoConstrucao=" + anoConstrucao +
                ", velMediaPorKm=" + velMediaPorKm +
                ", precoMedioPorKm=" + precoMedioPorKm +
                ", clasisificacao=" + clasisificacao +
                ", numKms=" + numKms +
                '}';
    }


}

