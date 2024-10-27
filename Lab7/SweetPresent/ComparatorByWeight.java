import java.util.Comparator;

public class ComparatorByWeight implements Comparator<Item>
{
    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getWeight(),o2.getWeight());
    }
}
