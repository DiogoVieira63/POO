public class Circulo {
    private double x;
    private double y;
    private double raio;


    /**
     * Construtores da classe Circulo
     * Declaração dos construtores por omissão, parametrizados e de cópia.
     */
    /**
     * Construtor por omissão
     */
    public Circulo (){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    /**
     * Construtor parametrizado.
     * Aceita como parâmetros os valores para cada coordenada e para o raio.
     */
    public Circulo (double x, double y,double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    /**
     * Construtor cópia.
     * Aceita como parâmetro um Circulo.
     * @param circle
     */

    public Circulo (Circulo circle){
        this.x = circle.x;
        this.y = circle.y;
        this.raio = circle.raio;
    }

    /**
     * Devolve o valor da coordenada em x.
     * @return valor da coordenada x
     */
    public double getX() {
        return x;
    }

    /**
     * Devolve o valor da coordenada em y.
     * @return valor da coordenada y
     */
    public double getY() {
        return y;
    }
    /**
     * Devolve o valor do raio.
     * @return valor do raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * Atualiza o valor da coordenada em x
     * @param x o novo valor da coordenada em x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Atualiza o valor da coordenada em y
     * @param y o novo valor da coordenada em y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Atualiza o valor do raio
     * @param raio o novo valor do raio
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     * Altera o posicionamento de ambas as coordenadas do Circulo
     * @param x O novo valor de x
     * @param y o novo valor de y
     */
    public void alteraCentro (double x, double y){
        this.setX(x);
        this.setY(y);
    }

    /**
     * Método que calcula a área do Circulo
     * @return A área do Circulo
     */
    public double calculaArea (){
        return Math.PI * Math.pow(getRaio(),2);
    }

    /**
     * Método que calcula o perímetro do Circulo
     * @return O perimetro do cirulo
     */
    public double calculaPerimetro (){
        return Math.PI * getRaio() * 2;
    }

    public boolean equals (Object o){
        if (this == o) return  true;
        if ((o == null) || (this.getClass()) != o.getClass()) return false;
        Circulo c = (Circulo) o;
        return (x == c.x && y == c.y && raio == c.raio);
    }

    public String toString() {
        return "Circulo{" +
                "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                '}';
    }
}
