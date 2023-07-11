package SistemadeSuporte; /*
  @author Diogo Vieira
 * @version 1.0
 * @use Academical Use
 */

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;


public class SistemadeSuporte {
    /**
     * The list of SistemadeSuporte.PedidodeSuporte
     */

    List<PedidodeSuporte> list;

    /**
     * Empty constrcutor
     */

    public SistemadeSuporte(){
        this.list = new ArrayList<>();
    }

    /**
     * Constructor with parameters
     * @param list The list of SistemadeSuporte.PedidodeSuporte
     */

    public SistemadeSuporte(List<PedidodeSuporte> list) {
        setList(list);
    }

    /**
     * Constructor giving a SistemadeSuporte.SistemadeSuporte
     * @param sistemadeSuporte Copy of the given SistemadeSuporte.SistemadeSuporte
     */

    public SistemadeSuporte (SistemadeSuporte sistemadeSuporte){
        setList(sistemadeSuporte.getList());
    }

    /**
     * Get the List
     * @return List
     */

    public List<PedidodeSuporte> getList() {
        return list;
    }

    /**
     * Setter of List
     * Copy of all values of given list to insert on this.list
     * @param list The list to be copied
     */

    public void setList(List<PedidodeSuporte> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    /**
     * Insert a SistemadeSuporte.PedidodeSuporte
     * @param pedido The SistemadeSuporte.PedidodeSuporte that will be inserted
     */
    public void inserePedido(PedidodeSuporte pedido){
        this.getList().add(pedido);
    }

    /**
     * Search for a SistemadeSuporte.PedidodeSuporte giving a user and the date
     * @param user The user
     * @param data The date
     * @return The SistemadeSuporte.PedidodeSuporte if case successful, otherwise null
     */

    public PedidodeSuporte procuraPedido(String user, LocalDateTime data){
        for (PedidodeSuporte pedido : getList()){
            if(pedido.getCaller().equals(user) && pedido.getCallTime().equals(data)) return pedido;
        }
        return null;//NOT FOUND
    }


    /**
     * Solves a SistemadeSuporte.PedidodeSuporte setting the info and the collaborator
     * @param pedido The PedidodeSuportee that will be solved
     * @param tecnico The collaborator that solved the SistemadeSuporte.PedidodeSuporte
     * @param info The info about the SistemadeSuporte.PedidodeSuporte
     */

    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info){
        pedido.setCollaborator(tecnico);
        pedido.setInfo(info);
        pedido.setSolved(true);
    }

    /**
     * Returns the list of all solved SistemadeSuporte.PedidodeSuporte (using internal iterators)
     * @return The List
     */

    public List<PedidodeSuporte> resolvidos(){
        return getList().stream().filter(PedidodeSuporte::isSolved).collect(Collectors.toList());
    }

    /**
     * Returns the list of all solved SistemadeSuporte.PedidodeSuporte (using external iterators)
     * @return The list of all solved SistemadeSuporte.PedidodeSuporte
     */

    public List<PedidodeSuporte> resolvidos2(){
        List<PedidodeSuporte> resolvedList = new ArrayList<>();
        Iterator<PedidodeSuporte> iter = getList().iterator();
        while (iter.hasNext()){
            PedidodeSuporte pedido = iter.next();
            if (pedido.isSolved()) resolvedList.add(pedido);
        }
        return resolvedList;
    }

    /**
     * Returns the collaborator that who solved most SistemadeSuporte.PedidodeSuporte (using internal iterators)
     * @return The collaborator
     */

    public String colaboradorTop(){
        List<String> s = getList().stream().
                filter(PedidodeSuporte::isSolved).
                sorted(Comparator.comparingInt(pedidodeSuporte -> (int) getList().stream().filter(pedidodeSuporte1 -> pedidodeSuporte.getCaller().equals(pedidodeSuporte1.getCaller())).count())).
                map(PedidodeSuporte::getCollaborator).
                collect(Collectors.toList());
        return s.get(s.size()-1);
    }

    /**
     * Returns the collaborator that who solved most SistemadeSuporte.PedidodeSuporte (using external iterators)
     * @return The collaborator
     */

    public String colaboradorTop2(){
        Iterator<PedidodeSuporte> iter = getList().iterator();
        int maxCount = 0;
        String result = null;
        while (iter.hasNext()){
            PedidodeSuporte pedido = iter.next();
            int count = 0;
            Iterator <PedidodeSuporte> inIter = getList().iterator();
            while (inIter.hasNext()){
                PedidodeSuporte inPedido = inIter.next();
                if (pedido.isSolved() && pedido.getCollaborator().equals(inPedido.getCollaborator())) count++;
            }
            if (count > maxCount) {
                result = pedido.getCollaborator();
                maxCount = count;
            }
        }
        return result;
    }

    /**
     * Returns the list of all solved SistemadeSuporte.PedidodeSuporte between two dates (using internal iterators)
     * @param inicio Start Date
     * @param fim End Date
     * @return The List
     */

    public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim){
        SistemadeSuporte copy = beetween(inicio,fim);
        return copy.getList().stream().
                filter(PedidodeSuporte::isSolved).
                collect(Collectors.toList());
    }

    /**
     * Returns the list of all solved SistemadeSuporte.PedidodeSuporte between two dates (using external iterators)
     * @param inicio Start Date
     * @param fim End Date
     * @return The List
     */

    public List<PedidodeSuporte> resolvidos2(LocalDateTime inicio, LocalDateTime fim){
        List <PedidodeSuporte> result = new ArrayList<>();
        Iterator<PedidodeSuporte> iter = getList().iterator();
        while (iter.hasNext()){
            PedidodeSuporte pedido = iter.next();
            if (pedido.isSolved() && pedido.getTimeConcluded().isBefore(fim) && pedido.getTimeConcluded().isAfter(inicio)){
                result.add(pedido);
            }
        }
        return result;
    }

    /**
     * Calculates the average time of solved SistemadeSuporte.PedidodeSuporte (using internal iterators)
     * @return The time in seconds
     */

    public double tempoMedioResolucao(){
        double total = getList().stream().
                filter(PedidodeSuporte::isSolved).
                map(PedidodeSuporte::tempoResolver).
                reduce((double) 0,Double::sum);
        return total/(double) nrResolvidos();
    }

    /**
     * Calculates the average time of solved SistemadeSuporte.PedidodeSuporte (using external iterators)
     * @return The time in seconds
     */

    public double tempoMediaResolucao2 (){
        double total = 0;
        Iterator<PedidodeSuporte> iter = getList().iterator();
        while (iter.hasNext()){
            total += iter.next().tempoResolver();
        }
        return total/(double) nrResolvidos();
    }

    /**
     * Number of solved Pedido
     * @return Count of solved Pedido
     */

    private int nrResolvidos (){
        return (int) getList().stream().filter(PedidodeSuporte::isSolved).count();
    }

    /**
     * Calculates the average time of solved SistemadeSuporte.PedidodeSuporte between two dates (using iternal iterators)
     * @param inicio Start Date
     * @param fim End Date
     * @return The time in seconds
     */

    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim){
        SistemadeSuporte copy = beetween(inicio,fim);
        return copy.tempoMedioResolucao();
    }

    /**
     * See what was slowest solved SistemadeSuporte.PedidodeSuporte
     * @return Pedido
     */

    public PedidodeSuporte pedidoMaisLongo(){
        List <PedidodeSuporte> result = getList().stream().
                filter(PedidodeSuporte::isSolved).
                sorted(comparingDouble(PedidodeSuporte::tempoResolver)).
                collect(Collectors.toList());
        return result.get(result.size()-1);
    }

    /**
     * See what was the slowest Pedido to solve beetween two dates
     * @return PedidodeSuporte
     */

    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim){
        SistemadeSuporte copy = beetween(inicio,fim);
        return copy.pedidoMaisLongo();
    }

    /**
     * See what was the quickest Pedido to solve
     * @return PedidodeSuporte
     */

    public PedidodeSuporte pedidoMaisCurto(){
        List <PedidodeSuporte> result = getList().stream().
                filter(PedidodeSuporte::isSolved).
                sorted(comparingDouble(PedidodeSuporte::tempoResolver)).
                collect(Collectors.toList());
        return result.get(0);
    }

    /**
     * Remove SistemadeSuporte.PedidodeSuporte that are not beetween  two dates
     * @param inicio Start Date
     * @param fim End Date
     * @return A copy of the SistemadeSuporte.SistemadeSuporte
     */

    public SistemadeSuporte beetween (LocalDateTime inicio, LocalDateTime fim){
        SistemadeSuporte copy = clone();
        copy.setList(copy.getList().stream().
                filter(pedidodeSuporte -> pedidodeSuporte.getTimeConcluded().isBefore(fim) && pedidodeSuporte.getCallTime().isAfter(inicio)).
                collect(Collectors.toList()));
        return copy;
    }

    /**
     * Method to clone a SistemadeSuporte.SistemadeSuporte
     * @return The SistemadeSuporte.SistemadeSuporte's clone
     */
    public SistemadeSuporte clone (){
        return new SistemadeSuporte(this);
    }


    /**
     * Equals method
     * @param o The object to compare to
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemadeSuporte that = (SistemadeSuporte) o;
        return getList().equals(that.getList());
    }

    /**
     * Convert the SistemadeSuporte.SistemadeSuporte to a String to display the results
     * @return The string
     */
    @Override
    public String toString() {
        return "SistemadeSuporte.SistemadeSuporte{" +
                "list=" + list +
                '}';
    }
}
