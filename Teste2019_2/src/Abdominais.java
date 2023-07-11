public class Abdominais extends Actividade {
    private int numeroRepeticoes ;
    private String tipoExercicio ;

    @Override
    public double caloriasGastas() {
        return getCaloriasPorUnidadeTempo() * numeroRepeticoes;
    }
}