import java.io.Serializable;

public class Exercicio implements Serializable {
    private Actividade actividade ;
    private String professor ;
    private String codExercicio ;

    public Actividade getActividade() {
        return actividade;
    }

    public void setActividade(Actividade actividade) {
        this.actividade = actividade;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(String codExercicio) {
        this.codExercicio = codExercicio;
    }

}