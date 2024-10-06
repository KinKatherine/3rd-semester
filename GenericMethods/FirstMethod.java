import java.util.Objects;

public class FirstMethod
{
    public static <T> Boolean containsValue(T[] array, T value)
    {
        for (T i : array)
        {
            if(Objects.equals(i,value))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Integer [] array = {1, 2, 3, 4, 5};
        System.out.println(containsValue(array, 6));
    }
}

