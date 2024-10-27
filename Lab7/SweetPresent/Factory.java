import java.util.ArrayList;
import java.util.Collections;

public class Factory
{
    public  static Present createPresent(ArrayList<Item> collection, double weight)
    {
        Present present = new Present();
        Collections.sort(collection,new ComparatorByWeight());
        if(collection.getFirst().getWeight() < weight)
        {
            double presentWeight = 0;
            while(weight-presentWeight > collection.getFirst().getWeight())
            {
                for(int i = 0; i<collection.size(); i++)
                {
                    if (weight-presentWeight >= collection.get(i).getWeight())
                    {
                        present.add(collection.get(i));
                        presentWeight += collection.get(i).getWeight();
                    }
                }
            }
        }
        return present;
    }
}
