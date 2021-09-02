import java.io.Serializable;

public class GrowingArrayOfActividade implements Serializable, Comparable {
    private Actividade [] lista ;
    private int tamanho ;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public Actividade get(int indice) throws IndiceIndisponivel{
        if (indice > lista.length -1) throw new IndiceIndisponivel ();
        return lista[indice];
    }

    public void add(Actividade a){
        if (lista.length == tamanho){
            Actividade[] actividades= new Actividade[tamanho*2];
            for (int i = 0; i < lista.length;i++){
                actividades[i] = lista[i];
            }
            lista = actividades;
            tamanho *= 2;
        }
        lista[tamanho++] = a;
    }

}