public class ThirdMethod
{
    public static <T extends Comparable<T>> int calculateCount(T[] array, T value)
    {
        int count = 0;
        for (T i : array)
        {
            if (i.compareTo(value) > 0)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Integer[] array = {1, 2, 3, 4, 5, 5,7};
        System.out.println(calculateCount(array, 4));
    }
}