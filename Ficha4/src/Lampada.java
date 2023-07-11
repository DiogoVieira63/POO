import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.NANOS;

public class Lampada {
    private enum Modo {
        ON(1), OFF(0), ECO(0.5);
        private final double value;

        private Modo(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }
    private Modo mode;
    private LocalDateTime last_turn;
    private double consumo;

    public Lampada(){
        LocalDateTime now = LocalDateTime.now();
        now = now.minusMinutes(5);
        this.mode = Modo.OFF;
        this.consumo = 0;
        this.last_turn = now;
    }
    public Lampada (Modo mode){
        this.mode = mode;
    }

    public void updateConsumo (){
        LocalDateTime now = LocalDateTime.now();
        long msecondsBetween = Math.abs(NANOS.between(now,this.last_turn)) /1000;
        this.consumo += msecondsBetween * this.mode.getValue();
    }
    public void lampON (){
        LocalDateTime now = LocalDateTime.now();
        this.updateConsumo();
        this.mode =Modo.ON;
        this.last_turn = now;
    }
    public void lampOFF(){
        LocalDateTime now = LocalDateTime.now();
        this.updateConsumo();
        this.mode = Modo.OFF;
        this.last_turn = now;
    }
    public void lampECO(){
        LocalDateTime now = LocalDateTime.now();
        this.updateConsumo();
        this.mode = Modo.ECO;
        this.last_turn = now;
    }

    public boolean isEco (){
        return getMode() == Modo.ECO;
    }

    public Modo getMode() {
        return mode;
    }

    public double getConsumo() {
        return consumo;
    }
    public double periodoConsumo (){
        LocalDateTime now = LocalDateTime.now();
        long msecondsBetween = Math.abs(NANOS.between(now,this.last_turn)) /1000;
        return getMode().getValue() * msecondsBetween;
    }

    public double totalConsumo (){
        return getConsumo() + this.periodoConsumo();
    }
}
