import java.security.PublicKey;
import java.time.LocalDateTime;

public class Eletrodomestico {
    private String ident ;
    private LocalDateTime inicio ;
    private LocalDateTime parcial ;
    private double consumoLigada ;
    private double consumoTotal ;
    private double consumoParcial ;
    private boolean estado ; // false - desligada , true - ligada

    public Eletrodomestico (Eletrodomestico eletrodomestico){
        this.ident = eletrodomestico.ident;
        this.inicio = eletrodomestico.inicio;
        this.parcial = eletrodomestico.parcial;
        this.consumoLigada = eletrodomestico.consumoLigada;
        this.consumoParcial = eletrodomestico.consumoParcial;
        this.estado = eletrodomestico.estado;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getParcial() {
        return parcial;
    }

    public void setParcial(LocalDateTime parcial) {
        this.parcial = parcial;
    }

    public double getConsumoLigada() {
        return consumoLigada;
    }

    public void setConsumoLigada(double consumoLigada) {
        this.consumoLigada = consumoLigada;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getConsumoParcial() {
        return consumoParcial;
    }

    public void setConsumoParcial(double consumoParcial) {
        this.consumoParcial = consumoParcial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Eletrodomestico (String ident , double consumo ) {
        this.ident = ident;
        this.consumoLigada = consumo;
    }
    // liga o eletrodoméstico
    public void EletrodomesticoON () {
        setEstado(true);
        setParcial(LocalDateTime.now());
    }
    // desliga o electrodoméstico
    public void EletrodomesticoOFF () {

    }
    // devolve o consumo desde o inı́cio
    public double totalConsumo () {

    }
    // devolve o consumo desde o último reset
    public double periodoConsumo () {

    }
    public void efectuarResetConsumo () {

    }

    public Eletrodomestico clone (){
        return new Eletrodomestico(this);
    }


}