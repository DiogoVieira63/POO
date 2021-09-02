package Grafos;

public class Teste_Grafo {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.addArco(1,2);
        g.addArco(1,3);
        g.addArco(2,6);
        g.addArco(3,4);
        g.addArco(4,3);
        g.addArco(4,5);
        g.addArco(4,6);
        g.addArco(5,7);
        g.addArco(6,7);

        System.out.println("Tamanho do grafo : " + g.size());
        System.out.println("Teste isSink: " + (g.isSink(7) && !g.isSink(1) ? "passou" : "não passou"));
        System.out.println("Teste isSource: " + (g.isSource(1) && !g.isSource(7) ? "passou" : "não passou"));
        System.out.println("Teste haCaminho: " + (g.haCaminho(1,3) && !g.haCaminho(7, 3) ? "passou" : "não passou"));
        System.out.println("Caminho de 1 a 5: " + g.getCaminho(1, 5));
        System.out.println("Fan out de 1 : " + g.fanOut(1));
        System.out.println("Fan out de 7 : " + g.fanOut(7));
        System.out.println("Fan in de 6 : " + g.fanIn(6));
        System.out.println("Fan in de 1 : " + g.fanIn(1));

        Grafo subg = new Grafo();
        subg.addArco(1,2);
        subg.addArco(2,6);
        subg.addArco(3,4);
        subg.addArco(5,7);

        System.out.println("Teste subGrafo: " + (subg.subGrafo(g) ? "passou" : "não passou"));

        subg.addArco(5,3);

        System.out.println("Teste subGrafo: " + (subg.subGrafo(g) ? "passou" : "não passou"));


    }
}
