public class Ficha3 {
    public static void main(String[] args) {
        /*Circulo circle = new Circulo(10,10,5);
        String s = circle.toString();
        System.out.println(s);

        Lampada lamp = new Lampada();
        lamp.lampON();
        lamp.lampOFF();
        System.out.println(lamp.getConsumo());

        JogoFutebol jogo = new JogoFutebol();
        jogo.goloVisitante();
        jogo.startGame();
        jogo.goloVisitado();
        jogo.goloVisitante();
        jogo.endGame();
        System.out.println(jogo.resultadoActual());
         */
        LinhaDeEncomenda encomenda = new LinhaDeEncomenda("10","produto",100,1,0.1,0.1);
        double total = encomenda.calculaValorLinhaEnc();
        double desconto = encomenda.calculaValorDesconto();
        System.out.println("total = " + total + "| desconto = " +desconto);
    }
}
