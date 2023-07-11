import java.io.Serializable;
import java.util.Comparator;

public abstract class Actividade implements Serializable , Comparator<Exercicio> {
    private String designacao ;
    private double caloriasPorUnidadeTempo;


    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getCaloriasPorUnidadeTempo() {
        return caloriasPorUnidadeTempo;
    }

    public void setCaloriasPorUnidadeTempo(double caloriasPorUnidadeTempo) {
        this.caloriasPorUnidadeTempo = caloriasPorUnidadeTempo;
    }

    @Override
    public int compare(Exercicio exercicio, Exercicio t1) {
        return (int) (exercicio.getActividade().caloriasGastas() - t1.getActividade().caloriasGastas());
    }

    public abstract double caloriasGastas ();
}