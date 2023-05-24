package exercises.streams.joins;

public class Tuple <T1, T2> {
    public final T1 v1;
    public final T2 v2;

    public Tuple(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "(" +
                 v1 +
                ", " + v2 +
                ')';
    }
}
