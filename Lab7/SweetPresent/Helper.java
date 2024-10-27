import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Helper
{
    public static String collectionToString(Collection<Item> collection)
    {
        StringBuffer string = new StringBuffer();
        for(Item i: collection)
        {
            string.append(i.toString());
            string.append("\n");
        }
        return string.toString();
    }

    public static String mapByKeyToString(HashMap<Double, ArrayList<Item>> collection, double key)
    {
        StringBuffer string = new StringBuffer();
        for(Item i: collection.get(key))
        {
            string.append(i.toString());
            string.append("\n");
        }
        return string.toString();
    }
}
