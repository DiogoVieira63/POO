package Parque_Lugar;

public class Lugar {
    private String matricula ;
    private String nome ;
    private int minutos ;
    private boolean permanente ;

    public Lugar (){
        this.matricula = "n/a";
        this.nome = "n/a";
        this.minutos = 0;
        this.permanente = false;
    }


    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar (Lugar lugar){
        this.matricula = lugar.getMatricula();
        this.nome = lugar.getNome();
        this.minutos =lugar.getMinutos();
        this.permanente = lugar.isPermanente();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    public Lugar clone (){
        return new Lugar(this);
    }

    @Override
    public String toString() {
        return "Parque_Lugar.Lugar{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", minutos=" + minutos +
                ", permanente=" + permanente +
                '}';
    }
}
