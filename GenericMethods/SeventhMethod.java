import java.util.function.Predicate;

public class SeventhMethod
{    public static <T> Integer calculateCount(T[] array, Predicate<T> predicate)
{
        int count = 0;
        for (T i : array)
        {
            if (predicate.test(i))
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Integer[] array = {1, 2, 3, 4, 5};
        Predicate<Integer> predicate = i -> i%2 == 0;
        System.out.println(calculateCount(array,predicate));
    }
}