public class Carro {
    private enum Modo {
        ON,OFF
    }
    private String marca;
    private String modelo;
    private int anoConstrucao;
    private double consumoKM;
    private int totalKM;
    private double mediaConsumo ;
    private int lastRideKM;
    private double mediaConsumoLastRide;
    private int consumoRegen;
    private Modo modo;

    public Carro(String marca, String modelo, int anoConstrucao, double consumoKM, int totalKM, double mediaConsumo, int lastRideKM, double mediaConsumoLastRide, int consumoRegen, Modo modo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoConstrucao = anoConstrucao;
        this.consumoKM = consumoKM;
        this.totalKM = totalKM;
        this.mediaConsumo = mediaConsumo;
        this.lastRideKM = lastRideKM;
        this.mediaConsumoLastRide = mediaConsumoLastRide;
        this.consumoRegen = consumoRegen;
        this.modo = modo;
    }

    public void ligaCarro (){
        setLastRideKM(0);
        setModo(Modo.ON);
    }

    public void desligaCarro (){
        setModo(Modo.OFF);
    }

    public void resetUltimaViagem (){
        setLastRideKM(0);
    }

    public void avancaCarro (double metros, double velocidade){
        double total = metros * velocidade;
        this.lastRideKM += total;
        this.totalKM += total;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getConsumoKM() {
        return consumoKM;
    }

    public void setConsumoKM(double consumoKM) {
        this.consumoKM = consumoKM;
    }

    public int getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(int totalKM) {
        this.totalKM = totalKM;
    }

    public double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    public int getLastRideKM() {
        return lastRideKM;
    }

    public void setLastRideKM(int lastRideKM) {
        this.lastRideKM = lastRideKM;
    }

    public double getMediaConsumoLastRide() {
        return mediaConsumoLastRide;
    }

    public void setMediaConsumoLastRide(double mediaConsumoLastRide) {
        this.mediaConsumoLastRide = mediaConsumoLastRide;
    }

    public int getConsumoRegen() {
        return consumoRegen;
    }

    public void setConsumoRegen(int consumoRegen) {
        this.consumoRegen = consumoRegen;
    }
}
