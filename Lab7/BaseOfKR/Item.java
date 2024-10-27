import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item<T>
{

    private ArrayList<T> itemCollection;

    public Item(ArrayList<T> itemCollection)
    {
        this.itemCollection = itemCollection;
    }

    public ArrayList<T> getItemCollection()
    {
        return itemCollection;
    }

    public T findMin(Comparator<? super T> comparator)
    {
        return Collections.min(itemCollection, comparator);
    }

    public T findMax(Comparator<? super T> comparator)
    {
        return Collections.max(itemCollection, comparator);
    }
}
