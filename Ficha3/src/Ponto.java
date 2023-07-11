import java.util.Objects;

public class Ponto<X, Y> {
    public final X x;
    public final Y y;

    public Ponto(X x, Y y) {
      this.x = x;
      this.y = y;
    }

  public Ponto(Ponto<X, Y> point){
    this.x = point.getX();
    this.y = point.getY();
  }

  public X getX() {
    return x;
  }

  public Y getY() {
    return y;
  }

  @Override
  protected Object clone() {
    return new Ponto<>(this);
  }

  @Override
  public String toString() {
    return "Ponto{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ponto<?, ?> ponto = (Ponto<?, ?>) o;
    return Objects.equals(getX(), ponto.getX()) && Objects.equals(getY(), ponto.getY());
  }

}
