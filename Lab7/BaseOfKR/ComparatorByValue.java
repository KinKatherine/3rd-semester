import java.util.Comparator;

public class ComparatorByValue implements Comparator<Number> {
    @Override
    public int compare(Number o1, Number o2) {
        return Double.compare(o1.doubleValue(), o2.doubleValue());
    }
}
