import java.util.Objects;

public class JogoFutebol {
    private enum Modo {
        TOSTART, INGAME, FINISHED
    }
    private Modo mode;
    private int golosVisitado;
    private int golosVisitante;

    public JogoFutebol(){
        this.mode=Modo.TOSTART;
        this.golosVisitado = 0;
        this.golosVisitante= 0;
    }

    public JogoFutebol(Modo mode, int golosVisitado, int golosVisitante) {
        this.mode = mode;
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
    }

    public JogoFutebol (JogoFutebol jogo){
        setMode(jogo.getMode());
        setGolosVisitante(jogo.getGolosVisitante());
        setGolosVisitado(jogo.getGolosVisitado());
    }

    public Modo getMode() {
        return mode;
    }

    public void setMode(Modo mode) {
        this.mode = mode;
    }

    public int getGolosVisitado() {
        return golosVisitado;
    }

    public void setGolosVisitado(int golosVisitado) {
        this.golosVisitado = golosVisitado;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }
    public void startGame (){
        setMode(Modo.INGAME);
    }
    public void endGame (){
        setMode(Modo.FINISHED);
    }
    public void goloVisitado (){
        if (getMode()==Modo.INGAME){
            setGolosVisitado(getGolosVisitado()+1);
        }
    }
    public void goloVisitante (){
        if (getMode()==Modo.INGAME){
            setGolosVisitante(getGolosVisitante()+1);
        }
    }
    public String resultadoActual (){
        return ("Visitado: " + getGolosVisitado() + " X " + getGolosVisitante() + " :Visitante");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoFutebol that = (JogoFutebol) o;
        return getGolosVisitado() == that.getGolosVisitado() && getGolosVisitante() == that.getGolosVisitante() && getMode() == that.getMode();
    }

    @Override
    protected Object clone()  {
        return new JogoFutebol(this);
    }

    @Override
    public String toString() {
        return "JogoFutebol{" +
                "mode=" + mode +
                ", golosVisitado=" + golosVisitado +
                ", golosVisitante=" + golosVisitante +
                '}';
    }
}


