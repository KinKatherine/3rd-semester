public class Exponential extends Progression
{
    Exponential(int start, int step)
    {
        super(start, step);
    }

    public int calculateElement(int number)
    {
        return (int) (super.getStart() * Math.pow(super.getStep(),number - 1));
    }

    public String extraConvertToString(int count)
    {
        return "Exponential: " + super.convertToString(count);
    }
}
