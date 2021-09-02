import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
    private Map<String,Veiculo> colecao;
    private final Map<String,Comparator<Veiculo>> comparatorMap = new HashMap<>();
    private boolean desconto;

    public void addComparador (String name, Comparator<Veiculo> comparator){
        comparatorMap.put(name,comparator);
    }

    public Comparator<Veiculo> getComparator (String name){
        return comparatorMap.get(name);
    }

    public DriveIt (){
        this.colecao = new HashMap<>();
        this.desconto = false;
    }

    public DriveIt (DriveIt driveIt){
        this.colecao = driveIt.getColecao();
        this.desconto = driveIt.desconto;
    }


    public Map<String, Veiculo> getColecao() {
        Map<String, Veiculo> map = new HashMap<>();
        for (Map.Entry<String, Veiculo> stringVeiculoEntry : colecao.entrySet()) {
            map.put(stringVeiculoEntry.getKey(), stringVeiculoEntry.getValue().clone());
        }
        return map;
    }

    public void setColecao(Map<String, Veiculo> colecao) {
        for (Map.Entry<String,Veiculo> entry : colecao.entrySet())
            colecao.put(entry.getKey(),entry.getValue());
    }

    public boolean isDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public boolean existeVeiculo(String cod){
        return colecao.containsKey(cod);
    }

    public int quantos(){
        return colecao.size();
    }

    public int quantos(String marca){
        Map<String,Veiculo> map = getColecao();
        return (int) map.entrySet().stream().
                filter(stringVeiculoEntry -> stringVeiculoEntry.getValue().getMatricula().equals(marca)).
                count();
    }

    public Veiculo getVeiculo(String cod) throws VeiculoNaoExisteException {
        if (!colecao.containsKey(cod)) throw new VeiculoNaoExisteException("Veiculo com " + cod + " não existe");
        return colecao.get(cod);
    }

    public void adiciona(Veiculo v) throws VeiculoJaExisteException {
        if (colecao.containsKey(v.getMatricula())) throw new VeiculoJaExisteException("Veiculo de matricula:" + v.getMatricula() + " já existe");
        colecao.put(v.getMatricula(), v);
    }

    public List<Veiculo> getVeiculos(){
        return new ArrayList<>(colecao.values());
    }

    public void adiciona(Set<Veiculo> vs) throws VeiculoJaExisteException {
        for (Veiculo v : vs) {
            adiciona(v);
        }
    }

    public void registarAluguer(String codVeiculo, int numKms) throws ValorInvalidoException{
        if (numKms < 0) throw new ValorInvalidoException("O valor " + numKms+ " é inválido");
        if (!colecao.containsKey(codVeiculo)){
            Veiculo veiculo = colecao.get(codVeiculo);
            veiculo.addNumKs(numKms);
            if (veiculo instanceof AutocarroInteligente) ((AutocarroInteligente) veiculo).addPontos (numKms);
            if (veiculo instanceof VeiculoPremium) ((VeiculoPremium) veiculo).addPontos (numKms);
        }
    }

    public void classificarVeiculo(String cod, int classificacao) throws ValorInvalidoException{
        if (classificacao > 10 || classificacao < 0) throw new ValorInvalidoException("O valor " + classificacao + " é inválido");
        if (!colecao.containsKey(cod)){
            Veiculo veiculo = colecao.get(cod);
            veiculo.addClassificacao(classificacao);
        }
    }

    public int custoRealKm(String cod){
        double result = 0;
        if (!colecao.containsKey(cod)){
            Veiculo veiculo = colecao.get(cod);
            result = veiculo.precoTotalPorKm();
        }
        return  (int) result;
    }

    public int quantosT(String tipo){
        int result = 0;
        for (Veiculo v : colecao.values()) {
            if (String.valueOf(v.getClass()).equals(tipo)) result++;
        }
        return result;
    }

    public List<Veiculo> veiculosOrdenadosCusto(){
        return colecao.values().stream().
                sorted(Comparator.comparingDouble(Veiculo::precoTotalPorKm).reversed()).
                collect(Collectors.toList());
    }

    public Veiculo veiculoMaisBarato(){
        List<Veiculo> list = veiculosOrdenadosCusto();
        return list.get(list.size()-1);
    }

    public Veiculo veiculoMenosUtilizado(){
        int menosKM = Integer.MAX_VALUE;
        Veiculo menor = null;
        for (Veiculo v: colecao.values()){
            if (v.getNumKms() < menosKM){
                menosKM = v.getNumKms();
                menor = v;
            }
        }
        return menor;
    }

    public void alteraPromocao (boolean estado){
        for (Veiculo veiculo : colecao.values()){
            if (veiculo instanceof VeiculoOcasiao){
                ((VeiculoOcasiao) veiculo).setDesconto(estado);
            }
        }
    }

    //Ordem natural dos veículos
    public Set<Veiculo> ordenarVeiculos(){
        return new TreeSet<>(getColecao().values());
    }

    public List<Veiculo> ordenarVeiculosList(){
        return getColecao().values().stream().
                sorted().
                collect(Collectors.toList());
    }

    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        return getColecao().values().stream()
                .collect(Collectors.toCollection(()->new TreeSet<>(c)));
    }

    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Comparator <Veiculo> comparator = getComparator(criterio);
        if (comparator == null) return null;
        return getColecao().values().stream().
                sorted(comparator).
                iterator();
    }

    public List<BonificaKms> daoPontos(){
        return colecao.values().stream().
                filter(veiculo -> veiculo instanceof BonificaKms).
                map(v -> (BonificaKms)v.clone()).
                collect(Collectors.toList());
    }


    public String saveState() {
            String outputFile = "driveIt.ser";
            try {
                FileOutputStream fos = new FileOutputStream(outputFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this);
                oos.close();
                fos.close();
                return outputFile;
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            return null;
        }


    public void loadState(String inputFile) {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DriveIt copy = (DriveIt) ois.readObject();
            this.setColecao(copy.getColecao());
            this.desconto = copy.desconto;
            ois.close();
            fis.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DriveIt{" +
                "colecao=" + colecao +
                ", desconto=" + desconto +
                '}';
    }

    public DriveIt clone (){
        return new DriveIt(this);
    }
}

