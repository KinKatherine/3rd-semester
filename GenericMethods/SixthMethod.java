public class SixthMethod
{
    public static <T extends Number> double calculateAverage(T[] array)
    {
        if (array.length == 0)
        {
            throw new IllegalArgumentException("Array is empty");
        }

        double sum = 0;
        for (T i : array)
        {
            sum += i.doubleValue();
        }

        return sum / array.length;
    }

    public static void main(String[] args)
    {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.5, 2.5, 3.5};

        System.out.println("intArray: " + calculateAverage(intArray));
        System.out.println("doubleArray: " + calculateAverage(doubleArray));
    }
}

