public class Bungalow extends Imovel {
    private double factorQualidade;
    private double espessuraParedes;

    public Bungalow (){
        super();
        this.factorQualidade = 0;
        this.espessuraParedes = 0;
    }

    public double precoDia() {
        return (getPrecoBase() * factorQualidade + getPrecoBase() * espessuraParedes)/2;
    }
}
