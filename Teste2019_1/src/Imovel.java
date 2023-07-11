import java.io.Serializable;

public abstract class Imovel implements Serializable {
    private String codImovel;
    private String morada;
    private String nifProprietario;
    private double area;
    private double precoBase;

    public Imovel(String codImovel, String morada, String nifProprietario, double area, double precoBase) {
        this.codImovel = codImovel;
        this.morada = morada;
        this.nifProprietario = nifProprietario;
        this.area = area;
        this.precoBase = precoBase;
    }

    public Imovel (){
        this.codImovel = "n/a";
        this.morada ="n/a";
        this.nifProprietario ="n/a";
        this.area = 0;
        this.precoBase = 0;
    }

    public String getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(String codImovel) {
        this.codImovel = codImovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNifProprietario() {
        return nifProprietario;
    }

    public void setNifProprietario(String nifProprietario) {
        this.nifProprietario = nifProprietario;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public abstract double precoDia();
}