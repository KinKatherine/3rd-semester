public class Liner extends Series
{
    Liner(double start, double step)
    {
        super(start, step);
    }

    public double calculateElement(int number)
    {
        return start +(number - 1) * step;
    }
}
