import java.util.Arrays;

public class Telemovel {
    private String marca;
    private String modelo;
    private double displayX;
    private double displayY;
    private int numMessages;
    private String[] messages;
    private double dimTotal;
    private double dimFotos;
    private double dimApps;
    private double usedSpace;
    private int numFotos;
    private int numApps;
    private String[] nameApps;

    public Telemovel (){
        this.marca = "None";
        this.modelo= "None";
        this.displayX = 1920;
        this.displayY = 1080;
        this.numMessages = 0;
        this.messages = new String[50];
        this.dimTotal = 1024+2048;
        this.dimFotos = 1024;
        this.dimApps = 2048;
        this.usedSpace = 0;
        this.numFotos = 0;
        this.numApps = 0;
        this.nameApps = new String[50];
    }

    public Telemovel (String marca, String modelo, double displayX, double displayY, int numMessages,
                      String[]messages,int dimTotal,int dimFotos, int dimApps, int usedSpace, int numFotos, int numApps,String[] nameApps){
        this.marca = marca;
        this.modelo = modelo;
        this.displayX = displayX;
        this.displayY = displayY;
        this.numMessages = numMessages;
        setMessages(messages);
        this.dimTotal = dimTotal;
        this.dimFotos = dimFotos;
        this.dimApps = dimApps;
        this.usedSpace = usedSpace;
        this.numFotos =numFotos;
        this.numApps =numApps;
        setNameApps(nameApps);
    }

    public double getDisplayX() {
        return displayX;
    }

    public double getDisplayY() {
        return displayY;
    }

    public double getDimApps() {
        return dimApps;
    }

    public double getDimFotos() {
        return dimFotos;
    }

    public int getnumMessages() {
        return numMessages;
    }

    public double getDimTotal() {
        return dimTotal;
    }

    public int getNumApps() {
        return numApps;
    }

    public int getNumFotos() {
        return numFotos;
    }

    public double getUsedSpace() {
        return usedSpace;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String[] getMessages() {
        return messages;
    }

    public String[] getNameApps() {
        return nameApps;
    }

    public void setMessages(String[] messages) {
        this.messages = Arrays.copyOf(messages, messages.length);;
    }

    public void setDimApps(int dimApps) {
        this.dimApps = dimApps;
    }

    public void setDimFotos(int dimFotos) {
        this.dimFotos = dimFotos;
    }

    public void setnumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public void setDimTotal(int dimTotal) {
        this.dimTotal = dimTotal;
    }

    public void setDisplayX(double displayX) {
        this.displayX = displayX;
    }

    public void setDisplayY(double displayY) {
        this.displayY = displayY;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNameApps(String[] nameApps) {
        this.nameApps = Arrays.copyOf(nameApps, nameApps.length);;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public void setUsedSpace(double usedSpace) {
        this.usedSpace = usedSpace;
    }

    private void addApp (String nome){
        if (getDimApps() == getNumApps()) return;
        this.nameApps[getNumApps()] = nome;
        setNumApps(getNumApps() + 1);
    }

    public boolean existeEspaco(int numeroBytes){
        return (this.dimTotal - this.usedSpace) > numeroBytes;
    }

    public void instalaApp (String nome, int tamanho){
        if (existeEspaco(tamanho)) {
            this.addApp(nome);
            setUsedSpace(this.usedSpace + tamanho);
        }
    }
    public void recebeMsg(String msg){
        if (this.numMessages == this.messages.length)return;
        this.messages[this.numMessages] = msg;
        this.numMessages++;
    }

    public double tamMedioApps(){
        return dimApps/numApps;
    }

    public String maiorMsg (){
        String maior = "";
        for (int i = 0; i < this.numMessages;i++){
            if (this.messages[i].length() > maior.length())
                maior = this.messages[i];
        }
        return maior;
    }
    public void removeApp (String nome, int tamanho){
        int i;
        for (i = 0; i < this.numApps;i++)
            if (this.nameApps[i].equals(nome))break;
        if (i == this.numApps) return;
        for (;i < this.numApps;i++)
            this.nameApps[i] = this.nameApps[i+1];
        this.numApps--;
        this.usedSpace -= tamanho;
    }
}
