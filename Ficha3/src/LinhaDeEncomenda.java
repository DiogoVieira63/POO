import java.util.Objects;

public class LinhaDeEncomenda {
    private String referencia;
    private String descricao;
    private double precoSemImposto;
    private int quantidade;
    private double imposto;
    private double desconto;

    public LinhaDeEncomenda(){
        this.referencia = "";
        this.descricao ="";
        this.precoSemImposto = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
    }

    public LinhaDeEncomenda(String referencia, String descricao, double precoSemImposto, int quantidade, double imposto, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoSemImposto = precoSemImposto;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public LinhaDeEncomenda (LinhaDeEncomenda encomenda){
        setReferencia(encomenda.getReferencia());
        setDescricao(encomenda.getDescricao());
        setPrecoSemImposto(encomenda.getPrecoSemImposto());
        setQuantidade(encomenda.getQuantidade());
        setImposto(encomenda.getImposto());
        setDesconto( encomenda.getDesconto());
    }

    public double calculaValorLinhaEnc(){
        return (getPrecoSemImposto()  - calculaValorDesconto()) +  getPrecoSemImposto() * getImposto();
    }

    public double calculaValorDesconto (){
        return getPrecoSemImposto() * getDesconto();
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoSemImposto() {
        return precoSemImposto;
    }

    public void setPrecoSemImposto(double precoSemImposto) {
        this.precoSemImposto = precoSemImposto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaDeEncomenda that = (LinhaDeEncomenda) o;
        return Double.compare(that.getPrecoSemImposto(), getPrecoSemImposto()) == 0 && getQuantidade() == that.getQuantidade() && Double.compare(that.getImposto(), getImposto()) == 0 && Double.compare(that.getDesconto(), getDesconto()) == 0 && Objects.equals(getReferencia(), that.getReferencia()) && Objects.equals(getDescricao(), that.getDescricao());
    }

    public LinhaDeEncomenda clone()  {
        return new LinhaDeEncomenda(this);
    }

    @Override
    public String toString() {
        return "LinhaDeEncomenda{" +
                "referencia='" + referencia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoSemImposto=" + precoSemImposto +
                ", quantidade=" + quantidade +
                ", imposto=" + imposto +
                ", desconto=" + desconto +
                '}';
    }
}
