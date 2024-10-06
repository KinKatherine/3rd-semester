public class SecondMethod
{
    public static <T> int calculateEntrance(T[] array, T value)
    {
        int count = 0;
        for (T i : array)
        {
            if (i.equals(value))
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Integer[] array = {1, 2, 3, 4, 5, 5};
        System.out.println(calculateEntrance(array, 5));
    }
}