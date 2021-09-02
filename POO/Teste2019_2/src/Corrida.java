public class Corrida extends Actividade implements ComDistancia {
    private double kmsPercorridos ;
    private double elevacao ;
    private double velocidade ;

    public double caloriasGastas() {
        return kmsPercorridos * getCaloriasPorUnidadeTempo() + (elevacao * 0.25);
    }

    public double getKmsPercorridos() {
        return 0;
    }
}