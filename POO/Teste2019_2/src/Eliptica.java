public class Eliptica extends Actividade implements ComDistancia {
    private double kmsPercorridos ;
    private double nivelEsforco ;
    private double minutos ;

    @Override
    public double caloriasGastas() {
        double calorias = kmsPercorridos * getCaloriasPorUnidadeTempo();
        double adicao = 0;
        if (minutos <= 4)
            adicao = minutos * 0.20;
        else adicao = minutos * 0.05;
        return adicao * calorias;
    }

    @Override
    public double getKmsPercorridos() {
        return 0;
    }
}