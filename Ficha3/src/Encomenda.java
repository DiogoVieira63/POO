import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Encomenda {
    private String clientName;
    private int fiscalNumber;
    private String clientAdress;
    private int encomendaNumber;
    private LocalDate date;
    private int numLinhas;
    private LinhaDeEncomenda[] linhas;

    public Encomenda(Encomenda encomenda){
        setClientName(encomenda.getClientName());
        setFiscalNumber(encomenda.getFiscalNumber());
        setClientAdress(encomenda.getClientAdress());
        setEncomendaNumber(encomenda.getEncomendaNumber());
        setDate(encomenda.getDate());
        setLinhas(encomenda.getLinhas());
        setNumLinhas(encomenda.getNumLinhas());
    }

    public Encomenda(String clientName, int fiscalNumber, String clientAdress, int encomendaNumber, LocalDate date, LinhaDeEncomenda[] linhas,int numLinhas) {
        this.clientName = clientName;
        this.fiscalNumber = fiscalNumber;
        this.clientAdress = clientAdress;
        this.encomendaNumber = encomendaNumber;
        this.date = date;
        this.linhas = linhas;
        this.numLinhas = numLinhas;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(int fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public int getEncomendaNumber() {
        return encomendaNumber;
    }

    public void setEncomendaNumber(int encomendaNumber) {
        this.encomendaNumber = encomendaNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LinhaDeEncomenda[] getLinhas() {
        return linhas;
    }

    public void setLinhas(LinhaDeEncomenda[] linhas) {
        this.linhas = Arrays.copyOf(linhas,linhas.length);
    }

    public int getNumLinhas() {
        return numLinhas;
    }

    public void setNumLinhas(int numLinhas) {
        this.numLinhas = numLinhas;
    }

    public LinhaDeEncomenda getIndex (int index){
        return this.linhas[index];
    }
    public double calculaValorTotal(){
        double total = 0;
        for (LinhaDeEncomenda linha :getLinhas()){
            total += linha.calculaValorLinhaEnc();
        }
        return total;
    }
    public double calculaValorDesconto(){
        double total = 0;
        for (LinhaDeEncomenda linha :getLinhas()){
            total += linha.calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos (){
        int total =0;
        for (LinhaDeEncomenda linha : getLinhas()){
            total += linha.getQuantidade();
        }
        return total;
    }
    public boolean existeProdutoEncomenda(String refProduto){
        for (LinhaDeEncomenda linha : getLinhas()){
            if(linha.getReferencia().equals(refProduto)) return true;
        }
        return false;
    }
     public void adicionaLinha(LinhaDeEncomenda linha){
        if (getNumLinhas() == getLinhas().length)
            this.linhas = Arrays.copyOf(getLinhas(),getLinhas().length*2);
        this.linhas[numLinhas]= linha;
        this.numLinhas++;
     }
    public void removeProduto(String codProd) {
        int i;
        for (i = 0; i < getNumLinhas(); i++)
            if (getIndex(i).getReferencia().equals(codProd)) break;
        for (; i < getNumLinhas(); i++)
            this.linhas[i] = this.linhas[i + 1];
    }
}
