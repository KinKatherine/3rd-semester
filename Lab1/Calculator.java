import java.io.IOException;

public class Calculator //вариант 4 
{
    public static void main(String[] args) throws Exception
    {
        if (args.length != 2)
        {
            throw new IOException("Invalid console arguments");
        }

        double x = 1;
        double inaccuracy = 0.001;
        double previous;
        double current;
        double sum = 0;
        int k = 1;

        try
        {
            x = Double.parseDouble(args[0]);
        }

        catch (NumberFormatException e)
        {
            System.err.println("Invalid first argument");
        }

        try
        {
            inaccuracy = Double.parseDouble(args[1]);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Invalid second argument");
        }

        previous = (Math.pow(-1, k) * Math.pow(x, k + 2)) / ((k + 1) * factorial((k+2)));
        current = previous;

        while (Math.abs(current)>inaccuracy)
        {
            sum+=current;
            k++;
            current = (previous*(-1) * x * k)/((k+1)*(k+2));
            previous = current;
        }

        System.out.println("Sum of the " + (k-1) +" members of the series: " + sum);
    }

    public static double factorial(double k)
    {
        double factorial = 1;
        for (int i = 1; i <= k; i++)
        {
            factorial *= i;
        }
        return factorial;
    }
}