package equalsExample;

public class PairWithEqualsAndHashcode {
    int x;
    int y;

    public PairWithEqualsAndHashcode(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairWithEqualsAndHashcode p5 = (PairWithEqualsAndHashcode) o;
        return x == p5.x && y == p5.y;
    }

    @Override
    public int hashCode() {
        return x*23+y*93;
    }

    @Override
    public String toString() {
        return "PairWithEqualsAndHashcode{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
