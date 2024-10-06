public class Exponential extends Series
{
    Exponential(double start, double step)
    {
        super(start, step);
    }

    public double calculateElement(int number)
    {
        return start * Math.pow(step,number - 1);
    }
}
