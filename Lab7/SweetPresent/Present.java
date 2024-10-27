import java.util.*;
import java.util.function.Predicate;

public class Present implements Iterable<Item>
{
    private ArrayList<Item> presentSweets = new ArrayList<>();

    public Present() {}

    public  ArrayList<Item> getPresentSweets()
    {
        return presentSweets;
    }

    public  Set<Item> findSweetBySugar(Predicate<Item> predicate)
    {
        Set<Item> sweets = new HashSet<>();
        for (Item elem : presentSweets)
        {
            if (predicate.test(elem))
            {
                sweets.add(elem);
            }
        }
        return sweets;
    }

    public  double getWeightInPresent(ItemType type)
    {
        double weight = 0;
        for (Item i:presentSweets)
        {
            if(type==ItemType.CANDY && i instanceof Candy)
            {
                weight += i.getWeight();
            }
            if(type==ItemType.CHOCOLATE && i instanceof Chocolate)
            {
                weight += i.getWeight();
            }
            if(type==ItemType.COOKIE && i instanceof Cookie)
            {
                weight += i.getWeight();
            }
        }
        return weight;
    }

    public double getProsInPresent(ItemType type)
    {
        int count = 0;
        for (Item i:presentSweets)
        {
            if(type==ItemType.CANDY && i instanceof Candy)
            {
                count++;
            }
            if(type==ItemType.CHOCOLATE && i instanceof Chocolate)
            {
                count++;
            }
            if(type==ItemType.COOKIE && i instanceof Cookie)
            {
                count++;
            }
        }
        return 100.0 * count/presentSweets.size();

    }

    public void add(Item item)
    {
        presentSweets.add(item);
    }

    public boolean isEmpty()
    {
        return presentSweets.isEmpty();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return presentSweets.iterator();
    }


    public HashMap<Double, ArrayList<Item>> groupSweetsByWeight()
    {
        HashMap<Double, ArrayList<Item>> groupOfSweets = new HashMap<>();
        for (Item item : presentSweets)
        {
            double weight = item.getWeight();
            if (!groupOfSweets.containsKey(weight))
            {
                groupOfSweets.put(weight, new ArrayList<>());
            }
            groupOfSweets.get(weight).add(item);
        }
        return groupOfSweets;
    }
}
