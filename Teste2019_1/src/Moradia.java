public class Moradia extends Imovel {
    private double areaPrivativa ;
    private double areaExterior ;

    public Moradia (){
        super();
        this.areaExterior= 0;
        this.areaPrivativa=0;
    }

    public double precoDia(){
        double areaTotal = areaPrivativa * 0.30 + areaExterior * 0.70;
        return areaTotal * getPrecoBase();
    }
}
