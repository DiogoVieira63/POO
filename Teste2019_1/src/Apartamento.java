public class Apartamento extends Imovel {
    private String andar ;
    private double factorQualidade ;

    public Apartamento (){
        super();
        this.andar = "n/a";
        this.factorQualidade = 0;
    }


    public double precoDia() {
        return factorQualidade * getPrecoBase();
    }

}
