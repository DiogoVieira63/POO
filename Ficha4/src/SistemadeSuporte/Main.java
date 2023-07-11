package SistemadeSuporte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemadeSuporte sistem = new SistemadeSuporte();
        PedidodeSuporte pedido = new PedidodeSuporte();
        PedidodeSuporte pedido2 = new PedidodeSuporte();
        List<PedidodeSuporte> list = new ArrayList<>();
        list.add(pedido);
        list.add(pedido2);
        SistemadeSuporte sistem2 = new SistemadeSuporte(list);
        //PEDIDO 1
        LocalDateTime now = LocalDateTime.now();
        pedido.setCaller("Diogo");
        pedido.setSolved(true);
        pedido.setTimeConcluded(now);
        pedido.setCallTime(now.minusMinutes(10));
        //PEDIDO 2
        pedido2.setCaller("Andrea");
        //Resolve Pedido
        sistem.resolvePedido(pedido2,"Alguém","Está tudo bem!");
//        sistem.resolvePedido(pedido,"Alguém","Está tudo bem!");
        pedido2.setTimeConcluded(now);
        pedido2.setCallTime(now.minusMinutes(30));
        //PEDIDO 3
        PedidodeSuporte pedido3 = pedido.clone();
        sistem.resolvePedido(pedido3,"Alguém","Mais ou menos");
        //Insere Pedido
        sistem.inserePedido(pedido);
        sistem.inserePedido(pedido2);
        sistem.inserePedido(pedido3);
        //EQUALS
//        System.out.println("São iguais? " + sistem.equals(sistem2));
        //Procura Pedido
//        System.out.println(sistem.procuraPedido("Diogo",now.minusMinutes(10)).toString());
        // Resolvidos
/*        System.out.println(sistem.resolvidos().toString());
        System.out.println(sistem.resolvidos2().toString());*/
        //COLABORADOR TOP
        System.out.println(sistem.colaboradorTop());
        System.out.println(sistem.colaboradorTop2());
        System.out.println(sistem.toString());
//        System.out.println(sistem2.toString());
    }

}
