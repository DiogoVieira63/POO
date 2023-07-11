import java.time.LocalDate;
import java.util.*;

public class EncEficiente {
    private String clientName;
    private int fiscalNumber;
    private String clientAdress;
    private int encomendaNumber;
    private LocalDate date;
    private ArrayList<LinhaEncomenda> array = null;


    EncEficiente(){
        this.clientName = "n/a";
        this.fiscalNumber = -1;
        this.clientAdress = "n/a";
        this.encomendaNumber = -1;
        this.date = LocalDate.now();
        this.array = new ArrayList<LinhaEncomenda>();
    }


    public EncEficiente(String clientName, int fiscalNumber, String clientAdress, int encomendaNumber, LocalDate date, ArrayList<LinhaEncomenda> array) {
        this.clientName = clientName;
        this.fiscalNumber = fiscalNumber;
        this.clientAdress = clientAdress;
        this.encomendaNumber = encomendaNumber;
        this.date = date;
        setArray(array);
    }

    EncEficiente (EncEficiente encomenda){
        this.clientName = encomenda.getClientName();
        this.fiscalNumber = encomenda.getFiscalNumber();
        this.clientAdress = encomenda.getClientAdress();
        this.encomendaNumber = encomenda.getEncomendaNumber();
        this.date = encomenda.getDate();
        setArray(encomenda.getArray());
    }

    public double calculaValorTotal(){
        double total = 0;
        Iterator<LinhaEncomenda> iter = this.array.iterator();
        while (iter.hasNext()){
            total += iter.next().calculaValorLinhaEnc();
        }
        return  total;
    }

    public double calculaValorDesconto (){
        double total = 0;
        Iterator <LinhaEncomenda> iter = this.array.iterator();
        while (iter.hasNext()){
            total += iter.next().calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos(){
        int total = 0;
        for (LinhaEncomenda linhaEncomenda : getArray()) {
            total += linhaEncomenda.getQuantidade();
        }
        return total;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        return this.array.stream().anyMatch(linhaEncomenda -> linhaEncomenda.getReferencia().equals(refProduto));
    }

    public void adicionaLinha(LinhaEncomenda linha){
        if (!existeProdutoEncomenda(linha.getReferencia())) {
            this.array.add(linha.clone());
        }
    }

    public void removeProduto(String codProd){
        this.array.removeIf(linhaEncomenda -> linhaEncomenda.getReferencia().equals(codProd));
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

    public ArrayList<LinhaEncomenda> getArray() {
        return array;
    }

    public void setArray(ArrayList<LinhaEncomenda> array) {
        this.array = new ArrayList<>();
        Iterator <LinhaEncomenda> iter = array.iterator();
        while (iter.hasNext())
            adicionaLinha(iter.next().clone());
    }

    public String toString() {
        return "EncEficiente{\n" +
                "clientName='" + clientName + '\'' +
                "| fiscalNumber=" + fiscalNumber +
                "| clientAdress='" + clientAdress + '\'' +
                "| encomendaNumber=" + encomendaNumber +
                "| date=" + date +
                "\narray=" + array +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncEficiente that = (EncEficiente) o;
        return
                getFiscalNumber() == that.getFiscalNumber() &&
                getEncomendaNumber() == that.getEncomendaNumber() &&
                getClientName().equals(that.getClientName()) &&
                getClientAdress().equals(that.getClientAdress()) &&
                getDate().equals(that.getDate()) &&
                getArray().equals(that.getArray());
    }

    public EncEficiente clone (){
        return new EncEficiente(this);
    }
}

