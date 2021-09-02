import java.util.Arrays;

public class Triangulo {
    private Ponto<Double,Double> p1;
    private Ponto<Double,Double> p2;
    private Ponto<Double,Double> p3;

    public Triangulo (){
        this.p1 = new Ponto(0,0);
        this.p2 = new Ponto(0,0);
        this.p3 = new Ponto(0,0);
    }

    public Triangulo(Ponto<Double, Double> p1, Ponto<Double, Double> p2, Ponto<Double, Double> p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double distance (Ponto<Double,Double> p1, Ponto<Double,Double> p2){
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }

    public double calculaAreaTriangulo (){
        double a = distance(getP1(),getP2()), b = distance(getP1(),getP3()) ,c = distance(getP2(),getP3());
        double p = (a+b+c)/2;
        return Math.sqrt(p * (p-a) *(p-b)*(p-c));
    }

    public double calculaPerimetroTriangulo (){
        return distance(getP1(),getP2()) + distance(getP2(),getP3()) + distance(getP2(),getP3());
    }

    public double calculaAltura (){
        double array[] = {getP1().getY(),getP2().getY(),getP3().getY()};
        Arrays.sort(array);
        return array[2] - array[0];
    }

    public Triangulo (Triangulo tri){
        setP1(tri.getP1());
        setP1(tri.getP2());
        setP1(tri.getP3());
    }

    public Ponto<Double, Double> getP1() {
        return p1;
    }

    public void setP1(Ponto<Double, Double> p1) {
        this.p1 = p1;
    }

    public Ponto<Double, Double> getP2() {
        return p2;
    }

    public void setP2(Ponto<Double, Double> p2) {
        this.p2 = p2;
    }

    public Ponto<Double, Double> getP3() {
        return p3;
    }

    public void setP3(Ponto<Double, Double> p3) {
        this.p3 = p3;
    }
}


