package equalsExample;

public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x= x;
        this.y= y;
    }

    @Override
    public String toString() {
        return "Pair{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
